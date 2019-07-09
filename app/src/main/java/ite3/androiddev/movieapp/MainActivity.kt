package ite3.androiddev.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import ite3.androiddev.movieapp.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigation_view.setNavigationItemSelectedListener {
            item->when(item.itemId){
            R.id.menu_discover -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.home_fragment, DiscoverFragment())
                    .commit()
                return@setNavigationItemSelectedListener true
            }
            R.id.menu_search -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.home_fragment, SearchFragment())
                    .commit()
                return@setNavigationItemSelectedListener true
            }
            R.id.menu_about -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.home_fragment, AboutFragment())
                    .commit()
                return@setNavigationItemSelectedListener true
            }
        }
            false
        }

        if (savedInstanceState == null)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.home_fragment, NowShowing())
            .commit()


        bottomNavigationView.setOnNavigationItemSelectedListener {
            menuItem: MenuItem ->
            when(menuItem.itemId){
                R.id.menu_trending -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_fragment, TrendingFragment())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_nowShowing->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_fragment,NowShowing())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main, menu)
//        val searchItem = menu?.findItem(R.id.menu_search)
//        val searchView = searchItem?.actionView as SearchView
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return true
//            }
//        })
//
//
//        return super.onCreateOptionsMenu(menu)
//    }
}
