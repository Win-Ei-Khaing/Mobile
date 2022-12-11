package com.example.cvbuilderapplication.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.cvbuilderapplication.R
import com.example.cvbuilderapplication.activity.WebActivity

class ContactFragment : Fragment(R.layout.fragment_contact) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<LinearLayout>(R.id.phone).setOnClickListener { onPhoneClicked() }
        view.findViewById<LinearLayout>(R.id.email).setOnClickListener { onEmailClicked() }
        view.findViewById<LinearLayout>(R.id.linkedIn).setOnClickListener { onLinkedInClicked() }
        view.findViewById<LinearLayout>(R.id.twitter).setOnClickListener { onTwitterClicked() }
        view.findViewById<LinearLayout>(R.id.github).setOnClickListener { onGithubClicked() }
    }

    private fun onPhoneClicked() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(getString(R.string.my_phone))
        startActivity(intent)
    }

    private fun onEmailClicked() {
        val intent = Intent(Intent.ACTION_SENDTO)
        val urlString =getString(R.string.intent_filter) + Uri.encode(getString(R.string.job_search_email)) + "?subject=" + Uri.encode(getString(R.string.email_subject)) + "&body=" + Uri.encode(getString(R.string.email_body))
        intent.data = Uri.parse(urlString)
        startActivity(intent)
    }

    private fun onLinkedInClicked() {
        val intent = Intent(context, WebActivity::class.java)
        intent.putExtra(getString(R.string.intent_key), getString(R.string.my_linkedin))
        startActivity(intent)
    }

    private fun onTwitterClicked() {
        val intent = Intent(context, WebActivity::class.java)
        intent.putExtra(getString(R.string.intent_key), getString(R.string.my_twitter))
        startActivity(intent)
    }

    private fun onGithubClicked() {
        val intent = Intent(context, WebActivity::class.java)
        intent.putExtra(getString(R.string.intent_key), getString(R.string.my_github))
        startActivity(intent)
    }
}