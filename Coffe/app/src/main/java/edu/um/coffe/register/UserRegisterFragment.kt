package edu.um.coffe.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import edu.um.coffe.R
import edu.um.coffe.data.User
import edu.um.coffe.databinding.UserregisterFragmentBinding
import org.w3c.dom.Text

class UserRegisterFragment : Fragment() {
    companion object {
        fun newInstance() = UserRegisterFragment()
    }

    private lateinit var registerViewModel: UserRegisterViewModel
    private lateinit var registerBtn : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.userregister_fragment,container,false)
        registerBtn = view.findViewById(R.id.signup)

        view.findViewById<EditText>(R.id.rusernameBox).addTextChangedListener {
            it?.let {
                registerViewModel.updateUsername(it.toString())
            }
        }
        view.findViewById<EditText>(R.id.rPasswordBox).addTextChangedListener {
            it?.let {
                registerViewModel.updatePassword(it.toString())
            }
        }
        view.findViewById<EditText>(R.id.emailBox).addTextChangedListener {
            it?.let {
                registerViewModel.updateEmail(it.toString())
            }
        }

        registerBtn.setOnClickListener {
            registerViewModel.run { registarUtilizador() }
            fragmentManager?.popBackStack()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerViewModel = ViewModelProvider(this).get(UserRegisterViewModel::class.java)
    }
}