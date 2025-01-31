package alcala.jose.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var operacion: Int=0
    var numero1:Double=0.0
    lateinit var tvnum1: TextView
    lateinit var tvnum2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        tvnum1=findViewById(R.id.tvnum1)
        tvnum2=findViewById(R.id.tvnum2)
        val btnBorrar: Button=findViewById(R.id.btnC)
        val btnIgual: Button=findViewById(R.id.btnIgual)
        btnIgual.setOnClickListener {
            var numero2: Double=tvnum2.text.toString().toDouble()
            var respuesta: Double=0.0

            when(operacion){
                1->respuesta=numero1+numero2
                2->respuesta=numero1-numero2
                3->respuesta=numero1*numero2
                4->respuesta=numero1/numero2

            }
            tvnum2.setText(respuesta.toString())
            tvnum1.setText("")

        }

        btnBorrar.setOnClickListener {
            tvnum1.setText("")
            tvnum2.setText("")
            numero1=0.0
            operacion=0
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun presionarDigito(view: View){
        // val tvnum2: TextView=findViewById(R.id.tvnum2)
        var num2: String=tvnum2.text.toString()

        when(view.id){
            R.id.btn0->tvnum2.setText(num2+"0")
            R.id.btn1->tvnum2.setText(num2+"1")
            R.id.btn2->tvnum2.setText(num2+"2")
            R.id.btn3->tvnum2.setText(num2+"3")
            R.id.btn4->tvnum2.setText(num2+"4")
            R.id.btn5->tvnum2.setText(num2+"5")
            R.id.btn6->tvnum2.setText(num2+"6")
            R.id.btn7->tvnum2.setText(num2+"7")
            R.id.btn8->tvnum2.setText(num2+"8")
            R.id.btn9->tvnum2.setText(num2+"9")
            R.id.btnPunto->tvnum2.setText(num2+".")
        }

    }

    fun clickOperacion(view: View){
        numero1=tvnum2.text.toString().toDouble()
        var num2Text: String=tvnum2.text.toString()
        tvnum2.setText("")
        when(view.id){
            R.id.btnMas->{
                tvnum1.setText(num2Text+"+")
                operacion=1
            }
            R.id.btnMenos->{
                tvnum1.setText(num2Text+"-")
                operacion=2
            }
            R.id.btnMultiplicar->{
                tvnum1.setText(num2Text+"*")
                operacion=3
            }
            R.id.btnDivision->{
                tvnum1.setText(num2Text+"/")
                operacion=4
            }

        }
    }
}