package com.san22.task

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Login : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          val v=inflater.inflate(R.layout.fragment_login, container, false)
        val emailEditText=v.findViewById<TextInputEditText>(R.id.emailEditText)
        val passwordEditText=v.findViewById<TextInputEditText>(R.id.passwordEditText)
        val LoginButton=v.findViewById<MaterialButton>(R.id.LoginButton)
        LoginButton.setOnClickListener()
        {
            val emailid=emailEditText.text.toString()
            val password:String=passwordEditText.text.toString()
            val user=LoginModel(emailid,password)

            GlobalScope.launch {

                 withContext(Dispatchers.IO)
                 {
                     sendPost(user)
                 }


            }

        }

        return v
    }

    private suspend fun sendPost(user:LoginModel) {

                 val myApi=client.api_Login
                 val call=myApi.senddatatoLoginApi(user.emailid,user.password)
                 call.enqueue(object: Callback<ResponseBody> {
                     override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                         Log.i("OK","Success ${response.code()}")
                     }

                     override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                         Log.i("Fail","Failure")
                     }

                 })



    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}