package edu.iesam.movies.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Con esta función nos protegemos para cargar las url de las imágenes
 * por si en un futuro Glide cambiara (de gratis a pago...)
 */
fun ImageView.loadUrl(url: String){
    Glide
        .with(this)
        .load(url)
        .into(this)
}