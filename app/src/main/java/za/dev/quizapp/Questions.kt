package za.dev.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class Questions : AppCompatActivity(), View.OnClickListener {


    private var  mCurrPos: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPos: Int = 0
    private var mUsername: String? = null
    private var mCorrectans: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null



    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)


        mUsername = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_1)
        tvOptionTwo = findViewById(R.id.tv_option_2)
        tvOptionThree = findViewById(R.id.tv_option_3)
        tvOptionFour = findViewById(R.id.tv_option_4)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        setQuestion()



    }

    private fun setQuestion() {



        defaultOptionsView()
        val question: Question = mQuestionList!![mCurrPos - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrPos
        tvProgress?.text = "$mCurrPos / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour


        if (mCurrPos == mQuestionList!!.size)
        {
            btnSubmit?.text = "Finish"
        }
        else
        {
            btnSubmit?.text = "Finish"
        }

    }


    private fun defaultOptionsView()
    {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }

        tvOptionTwo?.let {
            options.add(1, it)
        }

        tvOptionThree?.let {
            options.add(2, it)
        }

        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int)
    {
        defaultOptionsView()


        mSelectedOptionPos = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )




    }

    override fun onClick(view: View?)
    {
       when(view?.id)
       {
           R.id.tv_option_1 -> {
               tvOptionOne?.let {
                   selectedOptionView(it, 1)
               }
           }

           R.id.tv_option_2 -> {
               tvOptionTwo?.let {
                   selectedOptionView(it, 2)
               }
           }

           R.id.tv_option_3 -> {
               tvOptionThree?.let {
                   selectedOptionView(it, 3)
               }
           }

           R.id.tv_option_4 -> {
               tvOptionFour?.let {
                   selectedOptionView(it, 4)
               }
           }

           R.id.btn_submit -> {

               if (mSelectedOptionPos == 0)
               {
                   mCurrPos++

                   when{
                       mCurrPos <= mQuestionList!!.size -> {setQuestion()}

                       else -> {
                           val intent = Intent(this, Result::class.java)
                           intent.putExtra(Constants.USER_NAME, mUsername)
                           intent.putExtra(Constants.CORRECT_ANS, mCorrectans)
                           intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                           startActivity(intent)
                           finish()
                       }
                   }
               }

               else {
                   val question = mQuestionList?.get(mCurrPos - 1)
                   if(question!!.correctAns != mSelectedOptionPos)
                   {
                       answerView(mSelectedOptionPos, R.drawable.wrong_option_border_bg)
                   }
                   else
                   {
                       mCorrectans++
                   }

                       answerView(question.correctAns, R.drawable.correct_option_border_bg)
                       if(mCurrPos == mQuestionList!!.size)
                       {
                           btnSubmit?.text = "Finish"
                       }
                   else
                       {
                           btnSubmit?.text = "Next"
                       }

                   mSelectedOptionPos = 0

               }
           }
       }
    }

    private fun answerView(ans:Int, drawableView:Int)
    {
        when(ans)
        {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this, drawableView)

            }

            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this, drawableView)

            }

            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this, drawableView)

            }

            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }


        }




    }



}