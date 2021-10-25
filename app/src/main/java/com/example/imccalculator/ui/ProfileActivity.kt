package com.example.imccalculator.ui

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.imccalculator.R
import com.example.imccalculator.model.User
import com.example.imccalculator.utils.convertStringToLocalDate
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ProfileActivity : AppCompatActivity() {

    lateinit var editEmail : EditText
    lateinit var editPassword : EditText
    lateinit var editName : EditText
    lateinit var editProfession : EditText
    lateinit var editHeight : EditText
    lateinit var editBirthDate : EditText
    lateinit var radioGenderMale : RadioButton
    lateinit var radioGenderFemale : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val etBirthDate = findViewById<EditText>(R.id.edit_birth_date)

        etBirthDate.setOnClickListener{
            val dp = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{ _, _year, _month, _day ->
                etBirthDate.setText("$_day/${_month + 1}/$_year")
            }, year, month, day)
            dp.show()
        }

        editEmail = findViewById<EditText>(R.id.edit_email)
        editPassword = findViewById<EditText>(R.id.edit_password)
        editName = findViewById<EditText>(R.id.edit_name)
        editProfession = findViewById<EditText>(R.id.edit_profession)
        editHeight = findViewById<EditText>(R.id.edit_height)
        editBirthDate = findViewById<EditText>(R.id.edit_birth_date)
        radioGenderMale = findViewById<RadioButton>(R.id.radio_male)
        radioGenderFemale = findViewById<RadioButton>(R.id.radio_female)

        val imageView = findViewById<ImageView>(R.id.profile_image)
        imageView.clipToOutline = true

        supportActionBar!!.title = "Novo Usuário"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.save_button -> {
                if(validateInputs()) {
                    var birthDate = convertStringToLocalDate(editBirthDate.text.toString());
                    val user = User(
                        1,
                        editName.text.toString(),
                        editEmail.text.toString(),
                        editPassword.text.toString(),
                        0,
                        java.lang.Double.parseDouble(editHeight.text.toString()),
                        LocalDate.of(
                            birthDate.year,
                            birthDate.month,
                            birthDate.dayOfMonth
                        ),
                        editProfession.text.toString(),
                        if(radioGenderFemale.isChecked) 'F' else 'M'
                    )

                    val data = getSharedPreferences("user", Context.MODE_PRIVATE)

                    val editor = data.edit()
                    editor.putInt("id", user.id)
                    editor.putString("nome", user.name)
                    editor.putString("email", user.email)
                    editor.putString("password", user.password)
                    editor.putInt("weight", user.weight)
                    editor.putFloat("height", user.height.toFloat())
                    editor.putString("birthDate", user.birthDate.toString())
                    editor.putString("profession", user.profession)
                    editor.putString("gender", user.gender.toString())
                    editor.apply()

                    Toast.makeText(this, "Perfil salvo com sucesso!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return true
    }

    fun validateInputs(): Boolean {

        var isValid = false;
        if(editEmail.text.isEmpty()) {
            editEmail.error = "O e-mail é obrigatório"
        } else if(editPassword.text.isEmpty()) {
            editPassword.error = "A senha é obrigatória"
        } else if(editPassword.text.length < 8) {
            editPassword.error = "A senha deve ter no mínimo 8 caracteres"
        } else if(!editPassword.text.contains("[0-9]".toRegex())) {
            editPassword.error = "É necessário possuir no mínimo um número"
        } else if(!editPassword.text.contains("[!\\\"#\$%&'()*+,-./:;\\\\\\\\<=>?@\\\\[\\\\]^_`{|}~]".toRegex())) {
            editPassword.error = "É necessário possuir no mínimo um caractere especial"
        } else if(editName.text.isEmpty()) {
            editName.error = "O nome é obrigatório"
        } else if(editProfession.text.isEmpty()) {
            editProfession.error = "O profissão é obrigatório"
        } else if(editHeight.text.isEmpty()) {
            editHeight.error = "O altura é obrigatório"
        } else if(editBirthDate.text.isEmpty()) {
            editBirthDate.error = "O data de nascimento é obrigatório"
        } else if(!radioGenderMale.isChecked && !radioGenderFemale.isChecked) {
            radioGenderMale.error = "É necessário indicar seu sexo"
        } else {
            isValid = true
        }
        return isValid;
    }

}