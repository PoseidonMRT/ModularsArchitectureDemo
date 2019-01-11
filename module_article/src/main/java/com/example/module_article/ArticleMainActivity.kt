package com.example.module_article

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.text.Html
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.Observable
import androidx.drawerlayout.widget.DrawerLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonsdk.RouterHub
import com.example.commonsdk.base.BaseActivity
import com.example.commonsdk.utils.DateUtils
import com.example.commonsdk.utils.PreferencesUtils
import com.example.commonservice.article.entity.ResponseArticleData
import kotlinx.android.synthetic.main.article_activity_main.*

@Route(path = RouterHub.ARTICLE_MAIN_ACTIVITY)
class ArticleMainActivity : BaseActivity() {

    private lateinit var articleMainViewModel: ArticleMainViewModel

    private lateinit var drawerToggle: ActionBarDrawerToggle

    private var popupWindow: PopupWindow? = null

    val KEY_TEXT_SIZE = "text_size"
    val KEY_NIGHT_MODE = "night_mode"

    val TEXT_SIZE_SMALLER = "smaller"
    val TEXT_SIZE_NORMAL = "normal"
    val TEXT_SIZE_BIGGER = "bigger"

    override fun getLayout(): Int = R.layout.article_activity_main

    override fun initComponent() {}

    override fun initViewModel() {
        articleMainViewModel = ViewModelFactory.getInstance(application).create(ArticleMainViewModel::class.java)

        articleMainViewModel.apply {
            todayArticle.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    var todayArticle: ResponseArticleData = todayArticle.get() as ResponseArticleData
                    article_author.text = todayArticle.author
                    article_content.text = Html.fromHtml(todayArticle.content)
                    article_title.text = todayArticle.title
                }
            })

            currentDate.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    var date = currentDate.get() as String
                    if (date == DateUtils.getCurrentDate()) {
                        article_main_next.visibility = View.GONE
                    } else {
                        article_main_next.visibility = View.VISIBLE
                    }
                }
            })
        }
    }

    override fun initViewState() {
        initDrawerLayout()
        initTextSize()
    }

    private fun initDrawerLayout() {
        drawerToggle = ActionBarDrawerToggle(
            this,
            article_main_drawer_layout,
            R.string.article_drawer_open,
            R.string.article_drawer_close
        )
        article_main_drawer_layout.addDrawerListener(drawerToggle)
        article_main_drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        article_main_drawer_layout.setScrimColor(Color.TRANSPARENT)
        drawerToggle.syncState()
    }

    private fun initTextSize(){
        var textSize = PreferencesUtils.getString(this@ArticleMainActivity,KEY_TEXT_SIZE,TEXT_SIZE_NORMAL)
        setTextAppearance(textSize)
    }

    override fun initData() {
        article_open_left_drawer_iv.setOnClickListener {
            if (!article_main_drawer_layout.isDrawerOpen(article_main_drawer_left_layout)) {
                article_main_drawer_layout.openDrawer(article_main_drawer_left_layout)
            }
        }

        article_open_right_drawer_iv.setOnClickListener {
            if (!article_main_drawer_layout.isDrawerOpen(article_main_drawer_right_layout)) {
                article_main_drawer_layout.openDrawer(article_main_drawer_right_layout)
            }
        }

        article_main_settings.setOnClickListener {
            closeLeftDrawer()
            showReadingSettingsPopupWindow()
        }

        article_main_next.setOnClickListener {
            closeRightDrawer()
            articleMainViewModel.loadArticleDate(1)
        }

        article_main_prev.setOnClickListener {
            closeRightDrawer()
            articleMainViewModel.loadArticleDate(-1)
        }

        article_main_random.setOnClickListener {
            closeRightDrawer()
            articleMainViewModel.loadArticleRandom()
        }

        article_main_today.setOnClickListener {
            closeRightDrawer()
            articleMainViewModel.loadTodayArticle()
        }
    }

    override fun onResume() {
        super.onResume()
        articleMainViewModel.loadTodayArticle()
    }

    private fun closeRightDrawer() {
        if (article_main_drawer_layout.isDrawerOpen(article_main_drawer_right_layout)) {
            article_main_drawer_layout.closeDrawer(article_main_drawer_right_layout)
        }
    }

    private fun closeLeftDrawer() {
        if (article_main_drawer_layout.isDrawerOpen(article_main_drawer_left_layout)) {
            article_main_drawer_layout.closeDrawer(article_main_drawer_left_layout)
        }
    }

    private fun showReadingSettingsPopupWindow(){
        if (popupWindow != null && popupWindow!!.isShowing){
            return
        }

        if (isFinishing){
            return
        }

        var popupWindowView:View = layoutInflater.inflate(R.layout.article_type_face_setting_layout,null)
        popupWindow = PopupWindow(popupWindowView,RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT)

        backgroundAlpha(0.5f)

        popupWindow!!.setBackgroundDrawable(BitmapDrawable())
        popupWindow!!.isOutsideTouchable = true

        initPopupWindowView(popupWindowView)

        popupWindow!!.showAtLocation(window.decorView,Gravity.BOTTOM,0,0)
        popupWindow!!.setOnDismissListener {
            backgroundAlpha(1.0f)
        }
    }

    private fun initPopupWindowView(view:View){
        var textSize = PreferencesUtils.getString(this@ArticleMainActivity,KEY_TEXT_SIZE,TEXT_SIZE_NORMAL)
        var normalTextView = view.findViewById<TextView>(R.id.article_type_face_text_size_normal)
        var smallerTextView = view.findViewById<TextView>(R.id.article_type_face_text_size_smaller)
        var biggerTextView = view.findViewById<TextView>(R.id.article_type_face_text_size_bigger)

        if (textSize == TEXT_SIZE_NORMAL){
            refreshTextViewState(normalTextView,true)
            refreshTextViewState(smallerTextView,false)
            refreshTextViewState(biggerTextView,false)
        }

        if (textSize == TEXT_SIZE_SMALLER){
            refreshTextViewState(normalTextView,false)
            refreshTextViewState(smallerTextView,true)
            refreshTextViewState(biggerTextView,false)
        }

        if (textSize == TEXT_SIZE_BIGGER){
            refreshTextViewState(normalTextView,false)
            refreshTextViewState(smallerTextView,false)
            refreshTextViewState(biggerTextView,true)
        }

        normalTextView.setOnClickListener {
            PreferencesUtils.putString(this@ArticleMainActivity,KEY_TEXT_SIZE,TEXT_SIZE_NORMAL)
            refreshTextViewState(normalTextView,true)
            refreshTextViewState(smallerTextView,false)
            refreshTextViewState(biggerTextView,false)
            setTextAppearance(TEXT_SIZE_NORMAL)
        }

        smallerTextView.setOnClickListener {
            PreferencesUtils.putString(this@ArticleMainActivity,KEY_TEXT_SIZE,TEXT_SIZE_SMALLER)
            refreshTextViewState(normalTextView,false)
            refreshTextViewState(smallerTextView,true)
            refreshTextViewState(biggerTextView,false)
            setTextAppearance(TEXT_SIZE_SMALLER)
        }

        biggerTextView.setOnClickListener {
            PreferencesUtils.putString(this@ArticleMainActivity,KEY_TEXT_SIZE,TEXT_SIZE_BIGGER)
            refreshTextViewState(normalTextView,false)
            refreshTextViewState(smallerTextView,false)
            refreshTextViewState(biggerTextView,true)
            setTextAppearance(TEXT_SIZE_BIGGER)
        }
    }

    private fun setTextAppearance(textSize:String?){
        if (textSize == TEXT_SIZE_NORMAL){
            article_title.setTextAppearance(this@ArticleMainActivity,R.style.ArticleTitleTextStyleNormal)
            article_author.setTextAppearance(this@ArticleMainActivity,R.style.ArticleAuthorTextStyleNormal)
            article_content.setTextAppearance(this@ArticleMainActivity,R.style.ArticleContentTextStyleNormal)
        }
        if (textSize == TEXT_SIZE_SMALLER){
            article_title.setTextAppearance(this@ArticleMainActivity,R.style.ArticleTitleTextStyleSmaller)
            article_author.setTextAppearance(this@ArticleMainActivity,R.style.ArticleAuthorTextStyleSmaller)
            article_content.setTextAppearance(this@ArticleMainActivity,R.style.ArticleContentTextStyleSmaller)
        }

        if (textSize == TEXT_SIZE_BIGGER){
            article_title.setTextAppearance(this@ArticleMainActivity,R.style.ArticleTitleTextStyleBigger)
            article_author.setTextAppearance(this@ArticleMainActivity,R.style.ArticleAuthorTextStyleBigger)
            article_content.setTextAppearance(this@ArticleMainActivity,R.style.ArticleContentTextStyleBigger)
        }
    }

    private fun refreshTextViewState(view:TextView,state:Boolean){
        if (state){
            view.setBackgroundColor(Color.BLACK)
            view.setTextColor(Color.WHITE)
        }else{
            view.setBackgroundColor(Color.WHITE)
            view.setTextColor(Color.BLACK)
        }
    }

    private fun backgroundAlpha(alpha:Float){
        var layoutParams:WindowManager.LayoutParams = window.attributes
        layoutParams.alpha = alpha
        window.attributes = layoutParams
    }
}
