package com.chatgptmini.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button
    private lateinit var chatText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)
        chatText = findViewById(R.id.chatText)

        sendButton.setOnClickListener {
            val message = messageInput.text.toString().trim()

            if (message.isEmpty()) return@setOnClickListener

            chatText.append("\nYou: $message\n")
            messageInput.text.clear()

            chatText.append("ChatGPT Mini: Gemini connection coming next...\n")
        }
    }
}
