package za.dev.quizapp

object Constants {


    const val USER_NAME: String = "user_name"
    const val  TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANS: String = "correct_ans"

    fun getQuestions(): ArrayList<Question>
    {
        val questionsList = ArrayList<Question>()

        val Q1 = Question(

            1,"What Country does this Flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Pakistan","Poland",
            1
        )
        questionsList.add(Q1)


        val Q2 = Question(

            2,"What Company's logo is it?",
            R.drawable.bmw,
            "Audi", "Hyundai",
            "BMW","Hummer",
            3
        )
        questionsList.add(Q2)


        val Q3 = Question(

            3,"What Luxury Car Comapny's Logo is it?",
            R.drawable.jaguarlogo,
            "Jaguar", "Mercedes",
            "Rolls Royce","Buggati",
            1
        )
        questionsList.add(Q3)


        val Q4 = Question(

            4,"Which Football Association's logo is it?",
            R.drawable.argentinalogo,
            "Argentina", "Spain",
            "Barcelona","Juventus",
            1
        )
        questionsList.add(Q4)



        val Q5 = Question(

            5,"Which Brand is it?",
            R.drawable.pepsi,
            "Pepsi", "Dew",
            "Coca-Cola","Monster",
            1
        )
        questionsList.add(Q5)


        val Q6 = Question(

            6,"Which Brand Logo is it?",
            R.drawable.nikelogo,
            "Adidas", "Outfitters",
            "Levi's","Nike",
            4
        )
        questionsList.add(Q6)



        val Q7 = Question(

            7,"Which App Logo is it?",
            R.drawable.netflix,
            "Whatsapp", "Tumblr",
            "Netflix","YouTube",
            3
        )
        questionsList.add(Q7)



        val Q8 = Question(

            8,"Whose logo is it?",
            R.drawable.playstationlogo,
            "Nintendo", "PlayStation",
            "Unity","XBOX",
            2
        )
        questionsList.add(Q8)



        val Q9 = Question(

            9,"Which App is it?",
            R.drawable.instalogo,
            "Snapchat", "Instagram",
            "LinkedIn","WeChat",
            2
        )
        questionsList.add(Q9)




        val Q10 = Question(

            10,"Which Brand is it?",
            R.drawable.pumalogo,
            "Adidas", "Leopard",
            "Puma","Jaguar",
            3
        )
        questionsList.add(Q10)




        return  questionsList


    }




}