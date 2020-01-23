package school.nbcc.rickandmorty

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var holder = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonTrue: Button = findViewById(R.id.btnTrue)
        buttonTrue.setOnClickListener {isTrue()}

        val buttonFalse: Button = findViewById(R.id.btnFalse)
        buttonFalse.setOnClickListener {isFalse()}

        val buttonBack: Button = findViewById(R.id.btnBack)
        buttonBack.setOnClickListener { lastQuestion(it) }

        var buttonNext: Button = findViewById(R.id.btnNext)
        buttonNext.setOnClickListener { nextQuestion(it) }


    }

    class Question(var question: Int, var answer: Boolean)

    var counter = 0;
    var firstTime = true;

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    private fun nextQuestion(view: View) {
        if (firstTime) {

            var questionNumber = questionBank[counter].question
            var theQuestion = findViewById<TextView>(R.id.tvQuestions)
            theQuestion.text = resources.getString(questionNumber)
            firstTime = false;

        } else {
            counter++;

            if (counter >= questionBank.size){
                counter = 0;
            }

            var questionNumber = questionBank[counter].question
            var theQuestion = findViewById<TextView>(R.id.tvQuestions)
            theQuestion.text = resources.getString(questionNumber)

        }


    }

    private fun lastQuestion(view: View) {
        if (firstTime){
            firstTime = false;
        }
        if (counter == 0){

            counter = 19;
            var questionNumber = questionBank[counter].question
            var theQuestion = findViewById<TextView>(R.id.tvQuestions)
            theQuestion.text = resources.getString(questionNumber)
        } else {
            counter--;
            var questionNumber = questionBank[counter].question
            var theQuestion = findViewById<TextView>(R.id.tvQuestions)
            theQuestion.text = resources.getString(questionNumber)
        }

    }

    private fun isTrue() {
        var questionNumber = questionBank[counter].answer
        if (questionNumber == true) {
            Toast.makeText(applicationContext, "You are correct!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(
                applicationContext,
                "You really should watch this show.... it's awesome!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    private fun isFalse() {
        var questionNumber = questionBank[counter].answer
        if (questionNumber == false) {
            Toast.makeText(applicationContext, "You are correct!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(
                applicationContext,
                "You really should watch this show.... it's awesome!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
