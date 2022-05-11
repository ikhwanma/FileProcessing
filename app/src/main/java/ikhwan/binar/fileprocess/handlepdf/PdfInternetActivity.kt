package ikhwan.binar.fileprocess.handlepdf

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import ikhwan.binar.fileprocess.R
import kotlinx.android.synthetic.main.activity_pdf_internet.*
import java.io.File

class PdfInternetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_internet)

        checkPdf()
    }

    fun showPdf(file: File){
        pdf_internet.fromFile(file)
            .defaultPage(0)
            .spacing(10)
            .load()
    }

    fun getPdfUrl() : String{
        return "https://kotlinlang.org/assets/kotlin-media-kit.pdf"
    }

    private fun downloadPdfFromInternet(url: String, dirPath: String, fileName: String) {
        PRDownloader.download(
            url,
            dirPath,
            fileName
        ).build()
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    Toast.makeText(this@PdfInternetActivity, "downloadComplete", Toast.LENGTH_LONG)
                        .show()
                    val downloadedFile = File(dirPath, fileName)
                    showPdf(downloadedFile)
                }

                override fun onError(error: com.downloader.Error?) {
                    Toast.makeText(
                        this@PdfInternetActivity,
                        "Error in downloading file : $error",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }


            })
    }

    fun getRootDirPath(context: Context): String {
        return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            val file: File = ContextCompat.getExternalFilesDirs(
                context.applicationContext,
                null
            )[0]
            file.absolutePath
        } else {
            context.applicationContext.filesDir.absolutePath
        }
    }

    fun checkPdf(){
        val fileName = "file.pdf"
        downloadPdfFromInternet(getPdfUrl(),getRootDirPath(this), fileName)
    }

}