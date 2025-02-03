package com.example.aka

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aka.databinding.FragmentPlacesSliderBinding
import com.example.aka.items.SlideItem
import com.example.aka.items.SliderAdapter
import kotlin.math.abs

class PlacesSliderFragment : Fragment() {
    private var _binding: FragmentPlacesSliderBinding? = null
    private val binding get() = _binding!!

    private val slideItems = listOf(
        SlideItem(R.drawable.loc_amber, "Амбер", "Столица бывшей империи Амбер, а ныне Аркен-Хар, основанная великим магом и богом Амберионом"),
        SlideItem(R.drawable.loc_kuria, "Дворец Курия", "Дворец влиятельной семьи близ крупного оазиса в центре Аландрии"),
        SlideItem(R.drawable.loc_jangar, "Жангар", "Остров близ Велтори, юридически часть Аркен-Хара, пристанище контрабандистов и наёмников"),
        SlideItem(R.drawable.loc_lonely, "Одинокий замок", "Владения в Восточном Аркен-Харе между Недрами и Святым лесом"),
        SlideItem(R.drawable.loc_madhar, "Мадхар", "Столица Аландрии, южной пустынной страны-контитента. В Аландрии поколениями правят могущественные маги Воды, которым покровительствует богиня Фреятрон"),
        SlideItem(R.drawable.loc_mitsal, "Митсаль", "Столица Южного Аркен-Хара, где расположена резиденция лорда-наместника Гаррета Сертана. На центральной площади стоит статуя императору Аркену"),
        SlideItem(R.drawable.loc_sydris, "Сайдрис", "Город на западе Велтори, славится самым крупным храмом богини Брейзарны и гильдией адвокатов"),
        SlideItem(R.drawable.loc_trimun, "Тримун", "Столица Велтори, один из самых крупных и богатых городов мира в лучшие времена"),
        SlideItem(R.drawable.loc_norbian, "Норбиан", "Город Велтори на границе с Восточным Аркен-Харом, славится ежегодным Осенним фестивалем"),
        SlideItem(R.drawable.loc_holyforest, "Святой лес", "Вечнозелёный, пропитанный магией лес, где живут друиды, служители бога Сардориса"),
        SlideItem(R.drawable.loc_shhadow, "Теневая башня", "Магическая пограничная башня, защищающая проход в холодный и мрачный регион Недра."),
        SlideItem(R.drawable.loc_prowkdwar, "Проукдвар", "Город в Недрах, где находится также Храм Канеродвара, рыцаря Амбериона"),
        SlideItem(R.drawable.loc_warhold, "Вардхолд", "Столица Восточного Аркен-Хара, один из самых богатых городов страны за счет влияния клана Нефритов"),
        SlideItem(R.drawable.loc_darasgrad, "Дарасград", "Город на границе Центрального и Восточного Аркен-Хара"),
        SlideItem(R.drawable.loc_janntar, "Янтарная башня", "Спрятанная в горах Центрального Аркен-Хара магическая библиотека Амбериона"),
        SlideItem(R.drawable.loc_karanard, "Каранард", "Столица Северного Аркен-Хара, шедевр древнего мага-архитектора с высокими белокаменными башнями и дворцами"),
        SlideItem(R.drawable.loc_precikvar, "Прециквар", "Огромный разрушенный город древних в Северном Аркен-Харе, который некогда был чудом света и, возможно, построен расой драконов"),
        SlideItem(R.drawable.loc_leonnaris, "Леонаррис", "Крупный город с крепостью в Центральном Аркен-Харе, через который проходит речной торговый путь"),
        SlideItem(R.drawable.loc_grogroz, "Грогроз", "Огромный лабиринт и древний подземный город в Центральном Аркен-Харе, не изученный до конца"),
        SlideItem(R.drawable.loc_stradgrad, "Стратгард", "Самый крупный и богатый город Южного Аркен-Хара, находится на полуострове Острие. Славится банковской гильдией и самым крупным банком страны"),
        SlideItem(R.drawable.loc_lansdar, "Лансдар", "Портовый город Южного Аркен-Хара на границе с Велтори"),
        SlideItem(R.drawable.loc_prisdar, "Придзар", "Город на границе Южного и Центрального Аркен-Хара, известный штаб-квартирой ордена инквизиции «Кровавая луна»"),
        SlideItem(R.drawable.loc_raykavion, "Райкавион", "Магическая академия, основанная лордом Гарретом Сертаном на месте старого замка Второго рыцаря Амбериона, Белого дракона Амадора Эйзарта. Академия находится в Южном Аркен-Харе на Драконьем острове. Герб академии — белый дракон на синем фоне"),
        SlideItem(R.drawable.loc_mortykan, "Мортикан", "Магическая академия, основанная лордом Ходрадом Винтерстоком на месте старого замка Третьего рыцаря Амбериона, Ледяного рыцаря Келленгоста Тримуна. Академия находится в Северном Аркен-Харе в горах. Герб академии — белый шипастый латный кулак на синем фоне"),
        SlideItem(R.drawable.loc_taravis, "Таравис", "Прибрежный город Велтори, ближайший к границе Аркен-Хара, часто служит перевалочным пунктом в путешествиях между странами, есть небольшой причал"),
        SlideItem(R.drawable.loc_anagramma, "Перевернутая башня", "Одна из серии зачарованных построек, сделанных демонами Нарсис-Шада во времена вторжения в мир людей"),
        SlideItem(R.drawable.loc_barakor, "Баракор", "Страна степных кочевников, вечно посягающая на границы с севера Аркен-Хара. Во времена Баракорского вторжение под предводительством вождя Но-Хада баракорские шаманы вырезали почти всех магов Аркен-Хара"),
        SlideItem(R.drawable.loc_narsisshad, "Нарсис-Шад", "Мир расы демонов, отделённый от мира людей магическим барьером. В разные времена случались вторжения демонов и людей с войной в обе стороны, после которых боги укрепили границы"),
    )

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlacesSliderBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Настройка ViewPager2
        val adapter = SliderAdapter(slideItems)
        binding.viewPager.adapter = adapter

        // Опционально: Добавить анимацию перехода
        binding.viewPager.setPageTransformer { page, position ->
            page.alpha = 0.5f
            page.translationX = position * page.width
            page.alpha = 1 - abs(position)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}