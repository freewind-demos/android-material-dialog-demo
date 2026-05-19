package demos.android.material.dialog.demo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var resultText: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        resultText = findViewById(R.id.resultText)
        
        findViewById<Button>(R.id.showDialogBtn).setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Material Dialog")
                .setMessage("这是一个 Material Design 对话框")
                .setPositiveButton("确定") { _, _ ->
                    resultText.text = "点击了确定"
                }
                .setNegativeButton("取消") { _, _ ->
                    resultText.text = "点击了取消"
                }
                .show()
        }
    }
}
