package com.example.imccalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
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