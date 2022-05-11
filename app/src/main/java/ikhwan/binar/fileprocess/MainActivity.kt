package ikhwan.binar.fileprocess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.fileprocess.handleimage.ImageHandleActivity
import ikhwan.binar.fileprocess.handlepdf.HandlePdfActivity
import ikhwan.binar.fileprocess.handlevideo.HandleVideoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_pdf.setOnClickListener {
            startActivity(Intent(this, HandlePdfActivity::class.java))
        }
        btn_video.setOnClickListener {
            startActivity(Intent(this, HandleVideoActivity::class.java))
        }
        btn_image.setOnClickListener {
            startActivity(Intent(this, ImageHandleActivity::class.java))
        }
    }
}