package app.izzi.izzi.mx.myappdemo.Actividades

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import app.izzi.izzi.mx.myappdemo.Fragments.FragmentUno
import app.izzi.izzi.mx.myappdemo.Fragments.FragmentoB
import app.izzi.izzi.mx.myappdemo.Fragments.ListaFragment
import app.izzi.izzi.mx.myappdemo.Fragments.ZapatosFragment
import app.izzi.izzi.mx.myappdemo.Modelos.Zapato
import app.izzi.izzi.mx.myappdemo.MyInterfaces.MyConstants
import app.izzi.izzi.mx.myappdemo.MyInterfaces.MyInterfaces
import app.izzi.izzi.mx.myappdemo.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MyInterfaces.ComunicateInterface,MyInterfaces.ComunicateInterfacedos{

    lateinit var mfragmentManager : FragmentManager
    lateinit var mListaFragment : ListaFragment
    lateinit var mZapatosFragment : ZapatosFragment

    lateinit var mFragmentoUno : FragmentUno
    lateinit var mFragmentoDos : FragmentoB




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mListaFragment = ListaFragment()
        mZapatosFragment = ZapatosFragment()
        mFragmentoDos = FragmentoB()
        mFragmentoUno = FragmentUno()
        setSupportActionBar(toolbar)
        mfragmentManager = supportFragmentManager
        val transaction = mfragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_holder_amarillo,mListaFragment)
        transaction.commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun comunica(zapato: Zapato?, queFragmentEs: Int) {
        val transaction = mfragmentManager.beginTransaction()
        when (queFragmentEs){
            MyConstants.FRAGMENT_UNO -> {
                mFragmentoDos = FragmentoB.newInstance(zapato)
                transaction.replace(R.id.fragment_holder_amarillo,mFragmentoDos)
            }
            MyConstants.FRAGMENT_DOs-> {
                mFragmentoUno = FragmentUno.newInstance(zapato)
                mFragmentoUno.setComunicateInterface(this)
                transaction.replace(R.id.fragment_holder_amarillo,mFragmentoUno);

            }
        }

        transaction.commit()

    }

    override fun comunica(zapato: Zapato?) {
        val transaction = mfragmentManager.beginTransaction()
        mFragmentoUno = FragmentUno.newInstance(zapato)
        mFragmentoUno.setComunicateInterface(this)
        transaction.replace(R.id.fragment_holder_amarillo,mFragmentoUno);
        transaction.commit()

    }
}
