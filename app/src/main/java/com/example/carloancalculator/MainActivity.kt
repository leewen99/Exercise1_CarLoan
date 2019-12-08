package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var carprice: EditText

    lateinit var downPay: EditText

    lateinit var loanPeriod: EditText

    lateinit var interestRate: EditText



    lateinit var carloan: TextView

    lateinit var interest: TextView

    lateinit var monthlyrepayment: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carprice = findViewById(R.id.editTextCarPrice)
        downPay = findViewById(R.id.editTextDownPayment)
        loanPeriod = findViewById(R.id.editTextLoanPeriod)
        interestRate = findViewById(R.id.editTextInterestRate)
        carloan = findViewById(R.id.textViewLoan)
        interest = findViewById(R.id.textViewInterest)
        monthlyrepayment = findViewById(R.id.textViewMonthlyRepayment)

        val calculateB: Button = findViewById(R.id.buttonCalculate)

        val resetB: Button = findViewById(R.id.buttonReset)

        calculateB.setOnClickListener { calculator() }
        resetB.setOnClickListener{ reset() }
    }

    private fun calculator(){
        val loanPay = Integer.parseInt(carprice.text.toString()) - Integer.parseInt(downPay.text.toString())

        val interestCar = Integer.parseInt(loanPay.toString()) * Integer.parseInt(interestRate.text.toString()) * Integer.parseInt(loanPeriod.text.toString())

        val monthlPay = (Integer.parseInt(loanPay.toString()) + Integer.parseInt(interestCar.toString())) / Integer.parseInt(loanPeriod.text.toString()) / 12

        carloan.setText("Loan: "+loanPay.toString())
        interest.setText("Interest: "+interestCar.toString())
        monthlyrepayment.setText("Monthly Repayment: "+monthlPay)


    }

    private fun reset(){
        carprice.setText("");
        downPay.setText("");
        loanPeriod.setText("");
        interestRate.setText("");



        carloan.setText("Loan:  ");

        interest.setText("Interst:  ");

        monthlyrepayment.setText("Monthly Repayment: ");

    }
}
