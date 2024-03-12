package demo.isep.popnot

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showButton: Button = findViewById(R.id.showButton)

        showButton.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Whats App")
            .setMessage("Do you want to uninstall the app?")
            .setIcon(R.drawable.ic_launcher_foreground)

            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .setNeutralButton("Yes") { _, _ ->
                Toast.makeText(
                    this,
                    "The app is successfully uninstalled",
                    Toast.LENGTH_SHORT
                ).show()

            }

            .setPositiveButton("Pick a Date") { _, _ ->
                showDatePickerDialog()
            }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, dayOfMonth ->
                // Handle date selection
                Toast.makeText(
                    this,
                    " The App Uninstalled in Selected Date: $dayOfMonth/${selectedMonth + 1}/$selectedYear",
                    Toast.LENGTH_SHORT
                ).show()
            },
            currentYear,
            currentMonth,
            currentDay
        )

        datePickerDialog.show()
    }
}
