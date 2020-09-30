package com.san22.task

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SignUp : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val v=inflater.inflate(R.layout.fragment_sign_up, container, false)
        val nameEt=v.findViewById<TextInputEditText>(R.id.nameEt)
        val phnoEt=v.findViewById<TextInputEditText>(R.id.phnoEt)
        val emailEt=v.findViewById<TextInputEditText>(R.id.emailEt)
        val passwordEt=v.findViewById<TextInputEditText>(R.id.passwordEt)
        val signUpButton=v.findViewById<MaterialButton>(R.id.SignUpButton)
        signUpButton.setOnClickListener()
        {
            val user=RegisterModel(name = nameEt.toString(),number = phnoEt.toString(),emailid = emailEt.toString(),password = passwordEt.toString())
            GlobalScope.launch {
                withContext(Dispatchers.IO)
                {
                    sendPost(user)
                }
            }

        }
        return v
    }

    private suspend fun sendPost(user: RegisterModel) {
        val myApi=client.api_Login
        val call=myApi.senddatatoRegisterApi(user.name,user.emailid,user.number,user.password)
        call.enqueue(object: Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.i("OK","Success ${response.code()}")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i("Fail","Failure ${t}")
            }

        })
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}