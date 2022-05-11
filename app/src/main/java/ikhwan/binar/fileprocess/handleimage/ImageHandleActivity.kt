package ikhwan.binar.fileprocess.handleimage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.fileprocess.R
import kotlinx.android.synthetic.main.activity_image_handle.*


class ImageHandleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_handle)

        btn_image.setOnClickListener {
            pickImageFromGallery()
        }

    }

    fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"

        startActivityForResult(intent, 200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 200 && resultCode == RESULT_OK) {
            img_handle.setImageURI(data?.data)
        }
    }
}