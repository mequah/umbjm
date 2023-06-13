package com.example.umbjm

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toogle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toogle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title ="Universitas Muhammadiyah Banjarmasin"

        replaceFragment(BerandaFragment(), "Beranda")

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
//                R.id.beranda -> Toast.makeText(applicationContext,"Beranda", Toast.LENGTH_SHORT).show()
//                R.id.profil -> Toast.makeText(applicationContext,"Profil",Toast.LENGTH_SHORT).show()
//                R.id.fakultas -> Toast.makeText(applicationContext,"Fakultas",Toast.LENGTH_SHORT).show()
//                R.id.akreditasi -> Toast.makeText(applicationContext, "Akreditasi", Toast.LENGTH_SHORT).show()

                R.id.beranda -> replaceFragment(BerandaFragment(), it.title.toString())
                R.id.profil -> replaceFragment(ProfilFragment(), it.title.toString())
                R.id.fakultas -> replaceFragment(FakultasFragment(), it.title.toString())
                R.id.akreditasi -> replaceFragment(AkreditasiFragment(), it.title.toString())
            }

            true
        }

    }

    private fun replaceFragment(fragment: Fragment, title:String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toogle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}