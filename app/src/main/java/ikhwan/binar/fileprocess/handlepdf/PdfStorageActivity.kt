package ikhwan.binar.fileprocess.handlepdf

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.fileprocess.R
import kotlinx.android.synthetic.main.activity_pdf_storage.*

class PdfStorageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_storage)

        /*pdf_storage.setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_OUTSIDE)
        getExternalFilesDir(null)?.mkdirs()
        val pdfs: Array<File> = getExternalFilesDir(null)?.listFiles { _: File?, name: String -> name.endsWith(".pdf") }
            ?: emptyArray()

        val list = mutableListOf<String>()
        pdfs.forEach { list.add(it.name) }

        if (list.size > 0) {
            AlertDialog.Builder(this)
                .setTitle("List of files")
                .setItems(list.toTypedArray()) { _: DialogInterface?, item: Int ->
                    pdf_storage.fromFile(File(getExternalFilesDir(null), list[item]))
                    pdf_storage.show()
                }
                .show()
        }*/

        selectPdfStorage()
    }

    fun showPdf(uri: Uri){
        pdf_storage.fromUri(uri).load()
    }

    fun selectPdfStorage(){
        val browseFile = Intent(Intent(Intent.ACTION_GET_CONTENT))
        browseFile.type = "application/pdf"
        browseFile.addCategory(Intent.CATEGORY_OPENABLE)

        startActivityForResult(Intent.createChooser(browseFile, ""), 99)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 99 && resultCode == Activity.RESULT_OK && data != null){
            val selectPdf = data.data
            showPdf(selectPdf!!)
        }
    }
}