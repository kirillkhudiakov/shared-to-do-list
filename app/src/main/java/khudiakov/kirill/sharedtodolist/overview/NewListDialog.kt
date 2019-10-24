package khudiakov.kirill.sharedtodolist.overview

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import khudiakov.kirill.sharedtodolist.R
import khudiakov.kirill.sharedtodolist.databinding.NewListDialogBinding

class NewListDialog(val onCreateList: (String) -> Unit) : DialogFragment() {

    private lateinit var binding: NewListDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireNotNull(activity).layoutInflater

        binding = DataBindingUtil.inflate(inflater, R.layout.new_list_dialog, null, false)
        builder.setView(binding.root)
            .setPositiveButton("Create") { _, _ ->
                onCreateList(binding.newListName.text.toString())
            }
            .setNegativeButton("Cancel") { _, _ ->
                dialog!!.cancel()
            }

        return builder.create()
    }
}