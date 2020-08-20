package com.example.demo1.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo1.bean.*;
import com.example.demo1.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class ArticleController {

    private QuestionTagService questionTagService;
    @Resource
    public void setQuestionTagService(QuestionTagService questionTagService) {
        this.questionTagService = questionTagService;
    }
    private AnswerService answerService;
    @Resource
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    private QuestionService questionService;
    @Resource
    public void setQuestionService(QuestionService questionService){
        this.questionService = questionService;

    }
    private CommentService commentService;
    @Resource
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    private LikeService likeService;
    @Resource
    public void setLikeService(LikeService likeService) {
        this.likeService = likeService;
    }
    private CollectService collectService;
    @Resource
    public void setCollectService(CollectService collectService) {
        this.collectService = collectService;
    }
    private TagService tagService;
    @Resource
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }
    private ArticleTagService articleTagService;
    @Autowired
    public void setArticle_tags(ArticleTagService articleTagService) {
        this.articleTagService = articleTagService;
    }
    private UserService userService;
    @Autowired
    public  void setUserService(UserService userService){
        this.userService = userService;
    }
    private ArticleService articleService;

    @Autowired
    public  void setArticleService(ArticleService articleService){
            this.articleService=articleService;
    }


//    @GetMapping("/getAllArticle")
//    public String getAllArticle(){
//        List<Article> articleList = new ArrayList<>();
//        try {
//            articleList = articleService.getAllArticle();
//            if (articleList==null)
//                return  "null";
//            else
//            {
//                System.out.println(articleList.toString());
//                return articleList.toString();
//            }
//
//        }catch ( Exception e){
//            e.printStackTrace();
//
//            return "error";
//        }
//
//    }

/*
 int articleId,articleAuthorId,likeNumber,collectNumber,commentNumber;
    String articleTitle,articleContent,articleDate;

    List<Tag> article_tags;
    User article_author;
    List<User> like_users,collect_user;
    List<Comment> comment_content;
 */

//（文章id，article_title,article_author,article_content,
//article_date(YYYY-MM-DD格式),article_tag(对象数组))
//@ResponseBody
//@GetMapping("/add")
//public  boolean getRandomString() {
//
//    List<User> res=new ArrayList<User>();
//    for(int ss=0;ss<1000;ss++){
//
//        String articleTitle ="文章标题"+ss;
//        int articleAuthorId =ss;
//
////        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//////        Random random = new Random();
//////        StringBuffer sb = new StringBuffer();
//////        for (int i = 0; i < 6; i++) {
//////            int number = random.nextInt(str.length());
//////            sb.append(str.charAt(number));
//////        }
//        List<String> a= new ArrayList<>(Arrays.asList("大學之道，在明明德，在親民，在止於至善。知止而后有定，定而后能靜，靜而后能安，安而后能慮，慮而后能得。物有本末，事有終始，知所先後，則近道矣。",
//                "古之欲明明德於天下者，先治其國；欲治其國者，先齊其家；欲齊其家者，先修其身；欲修其身者，先正其心；欲正其心者，先誠其意；欲誠其意者，先致其知，致知在格物。物格而後知至，知至而後意誠，意誠而後心正，心正而後身修，身修而後家齊，家齊而後國治，國治而後天下平。自天子以至於庶人，壹是皆以修身為本。其本亂而末治者否矣，其所厚者薄，而其所薄者厚，未之有也！此謂知本，此謂知之至也。",
//                "所謂誠其意者，毋自欺也，如惡惡臭，如好好色，此之謂自謙，故君子必慎其獨也！小人閑居為不善，無所不至，見君子而後厭然，掩其不善，而著其善。人之視己，如見其肺肝然，則何益矣！此謂誠於中，形於外，故君子必慎其獨也。曾子曰：「十目所視，十手所指，其嚴乎！」富潤屋，德潤身，心廣體胖，故君子必誠其意。",
//                "《詩》云：「瞻彼淇澳，菉竹猗猗。有斐君子，如切如磋，如琢如磨。瑟兮僩兮，赫兮喧兮。有斐君子，終不可諠兮！」「如切如磋」者，道學也；「如琢如磨」者，自修也；「瑟兮僩兮」者，恂慄也；「赫兮喧兮」者，威儀也；「有斐君子，終不可諠兮」者，道盛德至善，民之不能忘也。《詩》云：「於戲前王不忘！」君子賢其賢而親其親，小人樂其樂而利其利，此以沒世不忘也。",
//                "《康誥》曰：「克明德。」《太甲》曰：「顧諟天之明命。」《帝典》曰：「克明峻德。」皆自明也。",
//                "湯之盤銘曰：「茍日新，日日新，又日新。」《康誥》曰：「作新民。」《詩》曰：「周雖舊邦，其命惟新。」是故君子無所不用其極。",
//                "《詩》云：「邦畿千里，惟民所止。」《詩》云：「緡蠻黃鳥，止于丘隅。」子曰：「於止，知其所止，可以人而不如鳥乎？」《詩》云：「穆穆文王，於緝熙敬止！」為人君，止於仁；為人臣，止於敬；為人子，止於孝；為人父，止於慈；與國人交，止於信。",
//                "子曰：「聽訟，吾猶人也，必也使無訟乎！」無情者不得盡其辭，大畏民志。此謂知本。",
//                "所謂修身在正其心者：身有所忿懥，則不得其正；有所恐懼，則不得其正；有所好樂，則不得其正；有所憂患，則不得其正。心不在焉，視而不見，聽而不聞，食而不知其味。此謂修身在正其心。",
//                "所謂齊其家在修其身者：人之其所親愛而辟焉，之其所賤惡而辟焉，之其所畏敬而辟焉，之其所哀矜而辟焉，之其所敖惰而辟焉。故好而知其惡，惡而知其美者，天下鮮矣！故諺有之曰：「人莫知其子之惡，莫知其苗之碩。」此謂身不修不可以齊其家。",
//                "所謂治國必先齊其家者，其家不可教而能教人者，無之。故君子不出家而成教於國：孝者，所以事君也；弟者，所以事長也；慈者，所以使眾也。《康誥》曰：「如保赤子」，心誠求之，雖不中不遠矣。未有學養子而後嫁者也！一家仁，一國興仁；一家讓，一國興讓；一人貪戾，一國作亂。其機如此。此謂一言僨事，一人定國。堯、舜率天下以仁，而民從之；桀、紂率天下以暴，而民從之。其所令反其所好，而民不從。是故君子有諸己而後求諸人，無諸己而後非諸人。所藏乎身不恕，而能喻諸人者，未之有也。故治國在齊其家。《詩》云：「桃之夭夭，其葉蓁蓁；之子于歸，宜其家人。」宜其家人，而後可以教國人。《詩》云：「宜兄宜弟。」宜兄宜弟，而後可以教國人。《詩》云：「其儀不忒，正是四國。」其為父子兄弟足法，而後民法之也。此謂治國在齊其家。",
//                "所謂平天下在治其國者：上老老而民興孝，上長長而民興弟，上恤孤而民不倍，是以君子有絜矩之道也。所惡於上，毋以使下；所惡於下，毋以事上；所惡於前，毋以先後；所惡於後，毋以從前；所惡於右，毋以交於左；所惡於左，毋以交於右。此之謂絜矩之道。《詩》云：「樂只君子，民之父母。」民之所好好之，民之所惡惡之，此之謂民之父母。《詩》云：「節彼南山，維石巖巖。赫赫師尹，民具爾瞻。」有國者不可以不慎，辟則為天下戮矣。",
//                "《詩》云：「殷之未喪師，克配上帝。儀監于殷，峻命不易。」道得眾則得國，失眾則失國。是故君子先慎乎德。有德此有人，有人此有土，有土此有財，有財此有用。德者本也，財者末也，外本內末，爭民施奪。是故財聚則民散，財散則民聚。是故言悖而出者，亦悖而入；貨悖而入者，亦悖而出。《康誥》曰：「惟命不于常！」道善則得之，不善則失之矣。楚書曰：「楚國無以為寶，惟善以為寶。」舅犯曰：「亡人無以為寶，仁親以為寶。」",
//                "《秦誓》曰：「若有一个臣，斷斷兮無他技，其心休休焉，其如有容焉。人之有技，若己有之；人之彥聖，其心好之，不啻若自其口出。實能容之，以能保我子孫黎民，尚亦有利哉！人之有技，媢嫉以惡之；人之彥聖，而違之俾不通。實不能容，以不能保我子孫黎民，亦曰殆哉！」唯仁人放流之，迸諸四夷，不與同中國，此謂唯仁人為能愛人，能惡人。見賢而不能舉，舉而不能先，命也；見不善而不能退，退而不能遠，過也。好人之所惡，惡人之所好，是謂拂人之性，災必逮夫身。是故君子有大道，必忠信以得之，驕泰以失之。",
//                "生財有大道。生之者眾，食之者寡，為之者疾，用之者舒，則財恒足矣。仁者以財發身，不仁者以身發財。未有上好仁而下不好義者也，未有好義其事不終者也，未有府庫財非其財者也。",
//                "孟獻子曰：「畜馬乘，不察於雞豚；伐冰之家，不畜牛羊；百乘之家，不畜聚斂之臣。與其有聚斂之臣，寧有盜臣。」此謂國不以利為利，以義為利也。長國家而務財用者，必自小人矣。彼為善之，小人之使為國家，災害并至。雖有善者，亦無如之何矣！此謂國不以利為利，以義為利也。",
//                "天命之謂性，率性之謂道，修道之謂教。道也者，不可須臾離也，可離非道也。是故君子戒慎乎其所不睹，恐懼乎其所不聞。莫見乎隱，莫顯乎微。故君子慎其獨也。喜怒哀樂之未發，謂之中；發而皆中節，謂之和；中也者，天下之大本也；和也者，天下之達道也。致中和，天地位焉，萬物育焉。",
//                "仲尼曰：「君子中庸，小人反中庸。君子之中庸也，君子而時中；小人之中庸也，小人而無忌憚也。」",
//                "子曰：「中庸其至矣乎！民鮮能久矣！」",
//                "子曰：「道之不行也，我知之矣：知者過之，愚者不及也。道之不明也，我知之矣：賢者過之，不肖者不及也。人莫不飲食也，鮮能知味也。」",
//                "子曰：「道其不行矣夫。」",
//                "子曰：「舜其大知也與！舜好問而好察邇言，隱惡而揚善，執其兩端，用其中於民，其斯以為舜乎！」",
//                "子曰：「人皆曰『予知』，驅而納諸罟擭陷阱之中，而莫之知辟也。人皆曰『予知』，擇乎中庸，而不能期月守也。」",
//                "子曰：「回之為人也，擇乎中庸，得一善，則拳拳服膺而弗失之矣。」",
//                "子曰：「天下國家可均也，爵祿可辭也，白刃可蹈也，中庸不可能也。」",
//                "子路問強。子曰：「南方之強與？北方之強與？抑而強與？寬柔以教，不報無道，南方之強也，君子居之。衽金革，死而不厭，北方之強也，而強者居之。故君子和而不流，強哉矯！中立而不倚，強哉矯！國有道，不變塞焉，強哉矯！國無道，至死不變，強哉矯！」",
//                "子曰：「素隱行怪，後世有述焉，吾弗為之矣。君子遵道而行，半涂而廢，吾弗能已矣。君子依乎中庸，遁世不見知而不悔，唯聖者能之。",
//                "君子之道費而隱。夫婦之愚，可以與知焉，及其至也，雖聖人亦有所不知焉；夫婦之不肖，可以能行焉，及其至也，雖聖人亦有所不能焉。天地之大也，人猶有所憾，故君子語大，天下莫能載焉；語小，天下莫能破焉。《詩》云：『鳶飛戾天，魚躍于淵。』言其上下察也。君子之道，造端乎夫婦，及其至也，察乎天地。」",
//                "子曰：「道不遠人。人之為道而遠人，不可以為道。《詩》云：『伐柯伐柯，其則不遠。』執柯以伐柯，睨而視之，猶以為遠。故君子以人治人，改而止。忠恕違道不遠，施諸己而不愿，亦勿施於人。君子之道四，丘未能一焉：所求乎子以事父，未能也；所求乎臣以事君，未能也；所求乎弟以事兄，未能也；所求乎朋友先施之，未能也。庸德之行，庸言之謹，有所不足，不敢不勉，有餘不敢盡；言顧行，行顧言，君子胡不慥慥爾！",
//                "君子素其位而行，不愿乎其外。素富貴，行乎富貴；素貧賤，行乎貧賤；素夷狄，行乎夷狄；素患難，行乎患難：君子無入而不自得焉。在上位不陵下，在下位不援上，正己而不求於人，則無怨。上不怨天，下不尤人。故君子居易以俟命，小人行險以徼幸。」",
//                "子曰：「射有似乎君子，失諸正鵠，反求諸其身。君子之道，辟如行遠必自邇，辟如登高必自卑。《詩》曰：『妻子好合，如鼓瑟琴；兄弟既翕，和樂且耽。宜爾室家，樂爾妻帑。』」子曰：「父母其順矣乎！」",
//                "子曰：「鬼神之為德，其盛矣乎！視之而弗見，聽之而弗聞，體物而不可遺。使天下之人齊明盛服，以承祭祀，洋洋乎如在其上，如在其左右。《詩》曰：『神之格思，不可度思！矧可射思！』夫微之顯，誠之不可掩如此夫。」",
//                "子曰：「舜其大孝也與！德為聖人，尊為天子，富有四海之內。宗廟饗之，子孫保之。故大德必得其位，必得其祿，必得其名，必得其壽。故天之生物，必因其材而篤焉。故栽者培之，傾者覆之。《詩》曰：『嘉樂君子，憲憲令德！宜民宜人，受祿于天。保佑命之，自天申之！』故大德者必受命。」",
//                "子曰：「無憂者其惟文王乎！以王季為父，以武王為子，父作之，子述之。武王纘大王、王季、文王之緒，壹戎衣而有天下，身不失天下之顯名；尊為天子，富有四海之內。宗廟饗之，子孫保之。武王末受命，周公成文、武之德，追王大王、王季，上祀先公以天子之禮。斯禮也，達乎諸侯、大夫及士、庶人。父為大夫，子為士，葬以大夫，祭以士。父為士，子為大夫，葬以士，祭以大夫。期之喪，達乎大夫；三年之喪，達乎天子；父母之喪，無貴賤，一也。」",
//                "子曰：「武王、周公，其達孝矣乎！夫孝者：善繼人之志，善述人之事者也。春、秋修其祖廟，陳其宗器，設其裳衣，薦其時食。宗廟之禮，所以序昭穆也；序爵，所以辨貴賤也；序事，所以辨賢也；旅酬下為上，所以逮賤也；燕毛，所以序齒也。踐其位，行其禮，奏其樂，敬其所尊，愛其所親，事死如事生，事亡如事存，孝之至也。郊社之禮，所以事上帝也；宗廟之禮，所以祀乎其先也。明乎郊社之禮、禘嘗之義，治國其如示諸掌乎！」",
//                "哀公問政。子曰：「文、武之政，布在方策，其人存，則其政舉；其人亡，則其政息。人道敏政，地道敏樹。夫政也者，蒲盧也。故為政在人，取人以身，修身以道，修道以仁。仁者人也，親親為大；義者宜也，尊賢為大。親親之殺，尊賢之等，禮所生也。在下位不獲乎上，民不可得而治矣！故君子不可以不修身；思修身，不可以不事親；思事親，不可以不知人；思知人，不可以不知天。天下之達道五，所以行之者三，曰：君臣也，父子也，夫婦也，昆弟也，朋友之交也，五者天下之達道也。知仁勇三者，天下之達德也，所以行之者一也。或生而知之，或學而知之，或困而知之，及其知之，一也；或安而行之，或利而行之，或勉強而行之，及其成功，一也。」",
//                "子曰：「好學近乎知，力行近乎仁，知恥近乎勇。知斯三者，則知所以修身；知所以修身，則知所以治人；知所以治人，則知所以治天下國家矣。凡為天下國家有九經，曰：修身也，尊賢也，親親也，敬大臣也，體群臣也，子庶民也，來百工也，柔遠人也，懷諸侯也。修身則道立，尊賢則不惑，親親則諸父昆弟不怨，敬大臣則不眩，體群臣則士之報禮重，子庶民則百姓勸，來百工則財用足，柔遠人則四方歸之，懷諸侯則天下畏之。齊明盛服，非禮不動，所以修身也；去讒遠色，賤貨而貴德，所以勸賢也；尊其位，重其祿，同其好惡，所以勸親親也；官盛任使，所以勸大臣也；忠信重祿，所以勸士也；時使薄斂，所以勸百姓也；日省月試，既廩稱事，所以勸百工也；送往迎來，嘉善而矜不能，所以柔遠人也；繼絕世，舉廢國，治亂持危，朝聘以時，厚往而薄來，所以懷諸侯也。凡為天下國家有九經，所以行之者一也。」",
//                "「凡事豫則立，不豫則廢。言前定則不跲，事前定則不困，行前定則不疚，道前定則不窮。在下位不獲乎上，民不可得而治矣；獲乎上有道：不信乎朋友，不獲乎上矣；信乎朋友有道：不順乎親，不信乎朋友矣；順乎親有道：反諸身不誠，不順乎親矣；誠身有道：不明乎善，不誠乎身矣。誠者，天之道也；誠之者，人之道也。誠者不勉而中，不思而得，從容中道，聖人也。誠之者，擇善而固執之者也。博學之，審問之，慎思之，明辨之，篤行之。有弗學，學之弗能，弗措也；有弗問，問之弗知，弗措也；有弗思，思之弗得，弗措也；有弗辨，辨之弗明，弗措也，有弗行，行之弗篤，弗措也。人一能之己百之，人十能之己千之。果能此道矣，雖愚必明，雖柔必強。」",
//                "自誠明，謂之性；自明誠，謂之教。誠則明矣，明則誠矣。唯天下至誠，為能盡其性；能盡其性，則能盡人之性；能盡人之性，則能盡物之性；能盡物之性，則可以贊天地之化育；可以贊天地之化育，則可以與天地參矣。",
//                "其次致曲。曲能有誠，誠則形，形則著，著則明，明則動，動則變，變則化。唯天下至誠為能化。",
//                "至誠之道，可以前知。國家將興，必有禎祥；國家將亡，必有妖孽。見乎蓍龜，動乎四體。禍福將至：善，必先知之；不善，必先知之。故至誠如神。",
//                "誠者自成也，而道自道也。誠者物之終始，不誠無物。是故君子誠之為貴。誠者非自成己而已也，所以成物也。成己，仁也；成物，知也。性之德也，合外內之道也，故時措之宜也。故至誠無息。不息則久，久則徵，徵則悠遠，悠遠則博厚，博厚則高明。博厚，所以載物也；高明，所以覆物也；悠久，所以成物也。博厚配地，高明配天，悠久無疆。如此者，不見而章，不動而變，無為而成。",
//                "天地之道，可壹言而盡也。其為物不貳，則其生物不測。天地之道，博也厚也，高也明也，悠也久也。今夫天，斯昭昭之多，及其無窮也，日月星辰系焉，萬物覆焉。今夫地，一撮土之多，及其廣厚，載華岳而不重，振河海而不泄，萬物載焉。今夫山，一拳石之多，及其廣大，草木生之，禽獸居之，寶藏興焉。今夫水，一勺之多，及其不測，黿鼉、蛟龍、魚鱉生焉，貨財殖焉。《詩》云：「維天之命，於穆不已！」蓋曰天之所以為天也。「於乎不顯！文王之德之純！」蓋曰文王之所以為文也，純亦不已。",
//                "大哉，聖人之道！洋洋乎發育萬物，峻極于天。優優大哉！禮儀三百，威儀三千，待其人然後行。故曰：苟不至德，至道不凝焉。故君子尊德性而道問學，致廣大而盡精微，極高明而中庸。溫故而知新，敦厚以崇禮。是故居上不驕，為下不倍；國有道，其言足以興，國無道，其默足以容。《詩》曰：「既明且哲，以保其身。」其此之謂與！",
//                "子曰：「愚而好自用，賤而好自專，生乎今之世，反古之道。如此者，災及其身者也。」非天子，不議禮，不制度，不考文。今天下車同軌，書同文，行同倫。雖有其位，苟無其德，不敢作禮樂焉；雖有其德，苟無其位，亦不敢作禮樂焉。",
//                "子曰：「吾說夏禮，杞不足徵也。吾學殷禮，有宋存焉；吾學周禮，今用之，吾從周。」王天下有三重焉，其寡過矣乎！上焉者雖善無徵，無徵不信，不信民弗從；下焉者雖善不尊，不尊不信，不信民弗從。故君子之道本諸身，徵諸庶民，考諸三王而不繆，建諸天地而不悖，質諸鬼神而無疑，百世以俟聖人而不惑。質諸鬼神而無疑，知天也；百世以俟聖人而不惑，知人也。是故君子動而世為天下道，行而世為天下法，言而世為天下則。遠之則有望，近之則不厭。《詩》曰：「在彼無惡，在此無射；庶幾夙夜，以永終譽！」君子未有不如此而蚤有譽於天下者也。",
//                "仲尼祖述堯、舜，憲章文、武；上律天時，下襲水土。辟如天地之無不持載，無不覆幬，辟如四時之錯行，如日月之代明。萬物并育而不相害，道并行而不相悖，小德川流，大德敦化，此天地之所以為大也。",
//                "唯天下至聖，為能聰明睿知，足以有臨也；寬裕溫柔，足以有容也；發強剛毅，足以有執也；齊莊中正，足以有敬也；文理密察，足以有別也。溥博淵泉，而時出之。溥博如天，淵泉如淵。見而民莫不敬，言而民莫不信，行而民莫不說。是以聲名洋溢乎中國，施及蠻貊；舟車所至，人力所通，天之所覆，地之所載，日月所照，霜露所隊；凡有血氣者，莫不尊親，故曰配天。",
//                "唯天下至誠，為能經綸天下之大經，立天下之大本，知天地之化育。夫焉有所倚？肫肫其仁！淵淵其淵！浩浩其天！苟不固聰明聖知達天德者，其孰能知之？",
//                "《詩》曰：「衣錦尚絅」，惡其文之著也。故君子之道，闇然而日章；小人之道，的然而日亡。君子之道：淡而不厭，簡而文，溫而理，知遠之近，知風之自，知微之顯，可與入德矣。",
//                "《詩》云：「潛雖伏矣，亦孔之昭！」故君子內省不疚，無惡於志。君子所不可及者，其唯人之所不見乎！",
//                "《詩》云：「相在爾室，尚不愧于屋漏。」故君子不動而敬，不言而信。",
//                "《詩》曰：「奏假無言，時靡有爭。」是故君子不賞而民勸，不怒而民威於鈇鉞。",
//                "《詩》曰：「不顯惟德！百辟其刑之。」是故君子篤恭而天下平。",
//                "《詩》曰：「予懷明德，不大聲以色。」子曰：「聲色之於以化民，末也。」《詩》曰：「德輶如毛」，毛猶有倫；「上天之載，無聲無臭」，至矣！"
//                ,"莊暴見孟子，曰：「暴見於王，王語暴以好樂，暴未有以對也。」曰：「好樂何如？」",
//                "孟子曰：「王之好樂甚，則齊國其庶幾乎！」",
//                "他日，見於王曰：「王嘗語莊子以好樂，有諸？」王變乎色，曰：「寡人非能好先王之樂也，直好世俗之樂耳。」",
//                "曰：「王之好樂甚，則齊其庶幾乎！今之樂猶古之樂也。」曰：「可得聞與？」",
//                "曰：「獨樂樂，與人樂樂，孰樂？」曰：「不若與人。」",
//                "曰：「與少樂樂，與眾樂樂，孰樂？」曰：「不若與眾。」",
//                "「臣請為王言樂：今王鼓樂於此，百姓聞王鐘鼓之聲，管籥之音，舉疾首蹙頞而相告曰：『吾王之好鼓樂，夫何使我至於此極也？父子不相見，兄弟妻子離散。』今王田獵於此，百姓聞王車馬之音，見羽旄之美，舉疾首蹙頞而相告曰：『吾王之好田獵，夫何使我至於此極也？父子不相見，兄弟妻子離散。』此無他，不與民同樂也。」",
//                "「今王鼓樂於此，百姓聞王鐘鼓之聲，管籥之音，舉欣欣然有喜色而相告曰：『吾王庶幾無疾病與？何以能鼓樂也？』今王田獵於此，百姓聞王車馬之音，見羽旄之美，舉欣欣然有喜色而相告曰『吾王庶幾無疾病與？何以能田獵也？』此無他，與民同樂也。今王與百姓同樂，則王矣。」",
//                "齊宣王問曰：「文王之囿方七十里，有諸？」",
//                "孟子對曰：「於傳有之。」",
//                "曰：「若是其大乎？」",
//                "曰：「民猶以為小也。」",
//                "曰：「寡人之囿方四十里，民猶以為大，何也？」",
//                "曰：「文王之囿方七十里，芻蕘者往焉，雉兔者往焉，與民同之。民以為小，不亦宜乎？臣始至於境，問國之大禁，然後敢入。臣聞郊關之內有囿方四十里，殺其麋鹿者如殺人之罪。則是方四十里，為阱於國中。民以為大，不亦宜乎？」",
//                "齊宣王問曰：「交鄰國有道乎？」",
//                "孟子對曰：「有。惟仁者為能以大事小，是故湯事葛，文王事昆夷；惟智者為能以小事大，故大王事獯鬻，句踐事吳。以大事小者，樂天者也；以小事大者，畏天者也。樂天者保天下，畏天者保其國。《詩》云：『畏天之威，于時保之。』」",
//                "王曰：「大哉言矣！寡人有疾，寡人好勇。」",
//                "對曰：「王請無好小勇。夫撫劍疾視曰，『彼惡敢當我哉』！此匹夫之勇，敵一人者也。王請大之！《詩》云：『王赫斯怒，爰整其旅，以遏徂莒，以篤周祜，以對于天下。』此文王之勇也。文王一怒而安天下之民。《書》曰：『天降下民，作之君，作之師。惟曰其助上帝，寵之四方。有罪無罪，惟我在，天下曷敢有越厥志？』一人衡行於天下，武王恥之。此武王之勇也。而武王亦一怒而安天下之民。今王亦一怒而安天下之民，民惟恐王之不好勇也。」",
//                "齊宣王見孟子於雪宮。王曰：「賢者亦有此樂乎？」",
//                "孟子對曰：「有。人不得，則非其上矣。不得而非其上者，非也；為民上而不與民同樂者，亦非也。樂民之樂者，民亦樂其樂；憂民之憂者，民亦憂其憂。樂以天下，憂以天下，然而不王者，未之有也。",
//                "「昔者齊景公問於晏子曰：『吾欲觀於轉附、朝儛，遵海而南，放于琅邪。吾何脩而可以比於先王觀也？』晏子對曰：『善哉問也！天子適諸侯曰巡狩，巡狩者巡所守也；諸侯朝於天子曰述職，述職者述所職也。無非事者。春省耕而補不足，秋省斂而助不給。夏諺曰：「吾王不遊，吾何以休？吾王不豫，吾何以助？一遊一豫，為諸侯度。」今也不然：師行而糧食，飢者弗食，勞者弗息。睊睊胥讒，民乃作慝。方命虐民，飲食若流。流連荒亡，為諸侯憂。從流下而忘反謂之流，從流上而忘反謂之連，從獸無厭謂之荒，樂酒無厭謂之亡。先王無流連之樂，荒亡之行。惟君所行也。』景公說，大戒於國，出舍於郊。於是始興發補不足。召大師曰：『為我作君臣相說之樂！』蓋徵招角招是也。其詩曰：『畜君何尤？』畜君者，好君也。」",
//                "齊宣王問曰：「人皆謂我毀明堂。毀諸？已乎？」",
//                "孟子對曰：「夫明堂者，王者之堂也。王欲行王政，則勿毀之矣。」",
//                "王曰：「王政可得聞與？」",
//                "對曰：「昔者文王之治岐也，耕者九一，仕者世祿，關市譏而不征，澤梁無禁，罪人不孥。老而無妻曰鰥。老而無夫曰寡。老而無子曰獨。幼而無父曰孤。此四者，天下之窮民而無告者。文王發政施仁，必先斯四者。《詩》云：『哿矣富人，哀此煢獨。』」",
//                "王曰：「善哉言乎！」",
//                "曰：「王如善之，則何為不行？」",
//                "王曰：「寡人有疾，寡人好貨。」",
//                "對曰：「昔者公劉好貨，《詩》云：『乃積乃倉，乃裹餱糧，于橐于囊。思戢用光。弓矢斯張，干戈戚揚，爰方啟行。』故居者有積倉，行者有裹糧也，然後可以爰方啟行。王如好貨，與百姓同之，於王何有？」",
//                "王曰：「寡人有疾，寡人好色。」",
//                "對曰：「昔者大王好色，愛厥妃。《詩》云：『古公亶甫，來朝走馬，率西水滸，至于岐下。爰及姜女，聿來胥宇。』當是時也，內無怨女，外無曠夫。王如好色，與百姓同之，於王何有？」",
//                "孟子謂齊宣王曰：「王之臣有託其妻子於其友，而之楚遊者。比其反也，則凍餒其妻子，則如之何？」",
//                "王曰：「棄之。」",
//                "曰：「士師不能治士，則如之何？」",
//                "王曰：「已之。」",
//                "曰：「四境之內不治，則如之何？」",
//                "王顧左右而言他。",
//                "孟子見齊宣王曰：「所謂故國者，非謂有喬木之謂也，有世臣之謂也。王無親臣矣，昔者所進，今日不知其亡也。」",
//                "王曰：「吾何以識其不才而舍之？」",
//                "曰：「國君進賢，如不得已，將使卑踰尊，疏踰戚，可不慎與？左右皆曰賢，未可也；諸大夫皆曰賢，未可也；國人皆曰賢，然後察之；見賢焉，然後用之。左右皆曰不可，勿聽；諸大夫皆曰不可，勿聽；國人皆曰不可，然後察之；見不可焉，然後去之。左右皆曰可殺，勿聽；諸大夫皆曰可殺，勿聽；國人皆曰可殺，然後察之；見可殺焉，然後殺之。故曰，國人殺之也。如此，然後可以為民父母。」",
//                "齊宣王問曰：「湯放桀，武王伐紂，有諸？」",
//                "孟子對曰：「於傳有之。」",
//                "曰：「臣弒其君可乎？」",
//                "曰：「賊仁者謂之賊，賊義者謂之殘，殘賊之人謂之一夫。聞誅一夫紂矣，未聞弒君也。」",
//                "孟子見齊宣王曰：「為巨室，則必使工師求大木。工師得大木。則王喜，以為能勝其任也。匠人斵而小之，則王怒，以為不勝其任矣。夫人幼而學之，壯而欲行之。王曰『姑舍女所學而從我』，則何如？今有璞玉於此，雖萬鎰，必使玉人彫琢之。至於治國家，則曰『姑舍女所學而從我』，則何以異於教玉人彫琢玉哉？」",
//                "齊人伐燕，勝之。宣王問曰：「或謂寡人勿取，或謂寡人取之。以萬乘之國伐萬乘之國，五旬而舉之，人力不至於此。不取，必有天殃。取之，何如？」",
//                "孟子對曰：「取之而燕民悅，則取之。古之人有行之者，武王是也。取之而燕民不悅，則勿取。古之人有行之者，文王是也。以萬乘之國伐萬乘之國，簞食壺漿，以迎王師。豈有他哉？避水火也。如水益深，如火益熱，亦運而已矣。」",
//                "齊人伐燕，取之。諸侯將謀救燕。宣王曰：「諸侯多謀伐寡人者，何以待之？」",
//                "孟子對曰：「臣聞七十里為政於天下者，湯是也。未聞以千里畏人者也。《書》曰：『湯一征，自葛始。』天下信之。『東面而征，西夷怨；南面而征，北狄怨。曰，奚為後我？』民望之，若大旱之望雲霓也。歸市者不止，耕者不變。誅其君而弔其民，若時雨降，民大悅。《書》曰：『徯我后，后來其蘇。』",
//                "「今燕虐其民，王往而征之。民以為將拯己於水火之中也，簞食壺漿，以迎王師。若殺其父兄，係累其子弟，毀其宗廟，遷其重器，如之何其可也？天下固畏齊之彊也。今又倍地而不行仁政，是動天下之兵也。王速出令，反其旄倪，止其重器，謀於燕眾，置君而後去之，則猶可及止也。」",
//                "鄒與魯鬨。穆公問曰：「吾有司死者三十三人，而民莫之死也。誅之，則不可勝誅；不誅，則疾視其長上之死而不救，如之何則可也？」",
//                "孟子對曰：「凶年饑歲，君之民老弱轉乎溝壑，壯者散而之四方者，幾千人矣；而君之倉廩實，府庫充，有司莫以告，是上慢而殘下也。曾子曰：『戒之戒之！出乎爾者，反乎爾者也。』夫民今而後得反之也。君無尤焉。君行仁政，斯民親其上、死其長矣。」",
//                "滕文公問曰：「滕，小國也，間於齊楚。事齊乎？事楚乎？」",
//                "孟子對曰：「是謀非吾所能及也。無已，則有一焉：鑿斯池也，築斯城也，與民守之，效死而民弗去，則是可為也。」",
//                "滕文公問曰：「齊人將築薛，吾甚恐。如之何則可？」",
//                "孟子對曰：「昔者大王居邠，狄人侵之，去之岐山之下居焉。非擇而取之，不得已也。苟為善，後世子孫必有王者矣。君子創業垂統，為可繼也。若夫成功，則天也。君如彼何哉？彊為善而已矣。」",
//                "滕文公問曰：「滕，小國也。竭力以事大國，則不得免焉。如之何則可？」",
//                "孟子對曰：「昔者大王居邠，狄人侵之。事之以皮幣，不得免焉；事之以犬馬，不得免焉；事之以珠玉，不得免焉。乃屬其耆老而告之曰：『狄人之所欲者，吾土地也。吾聞之也：君子不以其所以養人者害人。二三子何患乎無君？我將去之。』去邠，踰梁山，邑于岐山之下居焉。邠人曰：『仁人也，不可失也。』從之者如歸市。或曰：『世守也，非身之所能為也。效死勿去。』君請擇於斯二者。」",
//                "魯平公將出。嬖人臧倉者請曰：「他日君出，則必命有司所之。今乘輿已駕矣，有司未知所之。敢請。」公曰：「將見孟子。」曰：「何哉？君所為輕身以先於匹夫者，以為賢乎？禮義由賢者出。而孟子之後喪踰前喪。君無見焉！」公曰：「諾。」",
//                "樂正子入見，曰：「君奚為不見孟軻也？」曰：「或告寡人曰，『孟子之後喪踰前喪』，是以不往見也。」曰：「何哉君所謂踰者？前以士，後以大夫；前以三鼎，而後以五鼎與？」曰：「否。謂棺槨衣衾之美也。」曰：「非所謂踰也，貧富不同也。」",
//                "樂正子見孟子，曰：「克告於君，君為來見也。嬖人有臧倉者沮君，君是以不果來也。」曰：「行或使之，止或尼之。行止，非人所能也。吾之不遇魯侯，天也。臧氏之子焉能使予不遇哉？」"
//        , "公孫丑問曰：「夫子當路於齊，管仲、晏子之功，可復許乎？」",
//                "孟子曰：「子誠齊人也，知管仲、晏子而已矣。或問乎曾西曰；『吾子與子路孰賢？』曾西蹴然曰：『吾先子之所畏也。』曰：『然則吾子與管仲孰賢？』曾西艴然不悅，曰：『爾何曾比予於管仲？管仲得君，如彼其專也；行乎國政，如彼其久也；功烈，如彼其卑也。爾何曾比予於是？』」曰：「管仲，曾西之所不為也，而子為我願之乎？」",
//                "曰：「管仲以其君霸，晏子以其君顯。管仲、晏子猶不足為與？」",
//                "曰：「以齊王，由反手也。」",
//                "曰：「若是，則弟子之惑滋甚。且以文王之德，百年而後崩，猶未洽於天下；武王、周公繼之，然後大行。今言王若易然，則文王不足法與？」",
//                "曰：「文王何可當也？由湯至於武丁，賢聖之君六七作。天下歸殷久矣，久則難變也。武丁朝諸侯有天下，猶運之掌也。紂之去武丁未久也，其故家遺俗，流風善政，猶有存者；又有微子、微仲、王子比干、箕子、膠鬲皆賢人也，相與輔相之，故久而後失之也。尺地莫非其有也，一民莫非其臣也，然而文王猶方百里起，是以難也。齊人有言曰：『雖有智慧，不如乘勢；雖有鎡基，不如待時。』",
//                "「今時則易然也。夏后、殷、周之盛，地未有過千里者也，而齊有其地矣；雞鳴狗吠相聞，而達乎四境，而齊有其民矣。地不改辟矣，民不改聚矣，行仁政而王，莫之能禦也。且王者之不作，未有疏於此時者也；民之憔悴於虐政，未有甚於此時者也。飢者易為食，渴者易為飲。孔子曰：『德之流行，速於置郵而傳命。』當今之時，萬乘之國行仁政，民之悅之，猶解倒懸也。故事半古之人，功必倍之，惟此時為然。」",
//                "公孫丑問曰：「夫子加齊之卿相，得行道焉，雖由此霸王不異矣。如此，則動心否乎？」",
//                "孟子曰：「否。我四十不動心。」",
//                "曰：「若是，則夫子過孟賁遠矣。」",
//                "曰：「是不難，告子先我不動心。」",
//                "曰：「不動心有道乎？」",
//                "曰：「有。北宮黝之養勇也，不膚撓，不目逃，思以一豪挫於人，若撻之於市朝。不受於褐寬博，亦不受於萬乘之君。視刺萬乘之君，若刺褐夫。無嚴諸侯。惡聲至，必反之。孟施舍之所養勇也，曰：『視不勝猶勝也。量敵而後進，慮勝而後會，是畏三軍者也。舍豈能為必勝哉？能無懼而已矣。』孟施舍似曾子，北宮黝似子夏。夫二子之勇，未知其孰賢，然而孟施舍守約也。昔者曾子謂子襄曰：『子好勇乎？吾嘗聞大勇於夫子矣：自反而不縮，雖褐寬博，吾不惴焉；自反而縮，雖千萬人，吾往矣。』孟施舍之守氣，又不如曾子之守約也。」",
//                "曰：「敢問夫子之不動心，與告子之不動心，可得聞與？」",
//                "「告子曰：『不得於言，勿求於心；不得於心，勿求於氣。』不得於心，勿求於氣，可；不得於言，勿求於心，不可。夫志，氣之帥也；氣，體之充也。夫志至焉，氣次焉。故曰：『持其志，無暴其氣。』」",
//                "「既曰『志至焉，氣次焉』，又曰『持其志無暴其氣』者，何也？」",
//                "曰：「志壹則動氣，氣壹則動志也。今夫蹶者趨者，是氣也，而反動其心。」",
//                "「敢問夫子惡乎長？」",
//                "曰：「我知言，我善養吾浩然之氣。」",
//                "「敢問何謂浩然之氣？」",
//                "曰：「難言也。其為氣也，至大至剛，以直養而無害，則塞于天地之閒。其為氣也，配義與道；無是，餒也。是集義所生者，非義襲而取之也。行有不慊於心，則餒矣。我故曰，告子未嘗知義，以其外之也。必有事焉而勿正，心勿忘，勿助長也。無若宋人然：宋人有閔其苗之不長而揠之者，芒芒然歸。謂其人曰：『今日病矣，予助苗長矣。』其子趨而往視之，苗則槁矣。天下之不助苗長者寡矣。以為無益而舍之者，不耘苗者也；助之長者，揠苗者也。非徒無益，而又害之。」",
//                "「何謂知言？」",
//                "曰：「詖辭知其所蔽，淫辭知其所陷，邪辭知其所離，遁辭知其所窮。生於其心，害於其政；發於其政，害於其事。聖人復起，必從吾言矣。」",
//                "「宰我、子貢善為說辭，冉牛、閔子、顏淵善言德行。孔子兼之，曰：『我於辭命則不能也。』然則夫子既聖矣乎？」",
//                "曰：「惡！是何言也？昔者子貢、問於孔子曰：『夫子聖矣乎？』孔子曰：『聖則吾不能，我學不厭而教不倦也。』子貢曰：『學不厭，智也；教不倦，仁也。仁且智，夫子既聖矣！』夫聖，孔子不居，是何言也？」",
//                "「昔者竊聞之：子夏、子游、子張皆有聖人之一體，冉牛、閔子、顏淵則具體而微。敢問所安。」",
//                "曰：「姑舍是。」",
//                "曰：「伯夷、伊尹何如？」",
//                "曰：「不同道。非其君不事，非其民不使；治則進，亂則退，伯夷也。何事非君，何使非民；治亦進，亂亦進，伊尹也。可以仕則仕，可以止則止，可以久則久，可以速則速，孔子也。皆古聖人也，吾未能有行焉；乃所願，則學孔子也。」",
//                "「伯夷、伊尹於孔子，若是班乎？」",
//                "曰：「否。自有生民以來，未有孔子也。」",
//                "曰：「然則有同與？」",
//                "曰：「有。得百里之地而君之，皆能以朝諸侯有天下。行一不義、殺一不辜而得天下，皆不為也。是則同。」",
//                "曰：「敢問其所以異？」",
//                "曰：「宰我、子貢、有若智足以知聖人。汙，不至阿其所好。宰我曰：『以予觀於夫子，賢於堯舜遠矣。』子貢曰：『見其禮而知其政，聞其樂而知其德。由百世之後，等百世之王，莫之能違也。自生民以來，未有夫子也。』有若曰：『豈惟民哉？麒麟之於走獸，鳳凰之於飛鳥，太山之於丘垤，河海之於行潦，類也。聖人之於民，亦類也。出於其類，拔乎其萃，自生民以來，未有盛於孔子也。』」",
//                "孟子曰：「以力假仁者霸，霸必有大國，以德行仁者王，王不待大。湯以七十里，文王以百里。以力服人者，非心服也，力不贍也；以德服人者，中心悅而誠服也，如七十子之服孔子也。《詩》云：『自西自東，自南自北，無思不服。』此之謂也。」",
//                "孟子曰：「仁則榮，不仁則辱。今惡辱而居不仁，是猶惡溼而居下也。如惡之，莫如貴德而尊士，賢者在位，能者在職。國家閒暇，及是時明其政刑。雖大國，必畏之矣。《詩》云：『迨天之未陰雨，徹彼桑土，綢繆牖戶。今此下民，或敢侮予？』孔子曰：『為此詩者，其知道乎！能治其國家，誰敢侮之？』今國家閒暇，及是時般樂怠敖，是自求禍也。禍褔無不自己求之者。《詩》云：『永言配命，自求多褔。』《太甲》曰：『天作孽，猶可違；自作孽，不可活。』此之謂也。」",
//                "孟子曰：「尊賢使能，俊傑在位，則天下之士皆悅而願立於其朝矣。市廛而不征，法而不廛，則天下之商皆悅而願藏於其市矣。關譏而不征，則天下之旅皆悅而願出於其路矣。耕者助而不稅，則天下之農皆悅而願耕於其野矣。廛無夫里之布，則天下之民皆悅而願為之氓矣。信能行此五者，則鄰國之民仰之若父母矣。率其子弟，攻其父母，自生民以來，未有能濟者也。如此，則無敵於天下。無敵於天下者，天吏也。然而不王者，未之有也。」",
//                "孟子曰：「人皆有不忍人之心。先王有不忍人之心，斯有不忍人之政矣。以不忍人之心，行不忍人之政，治天下可運之掌上。所以謂人皆有不忍人之心者，今人乍見孺子將入於井，皆有怵惕惻隱之心。非所以內交於孺子之父母也，非所以要譽於鄉黨朋友也，非惡其聲而然也。由是觀之，無惻隱之心，非人也；無羞惡之心，非人也；無辭讓之心，非人也；無是非之心，非人也。惻隱之心，仁之端也；羞惡之心，義之端也；辭讓之心，禮之端也；是非之心，智之端也。人之有是四端也，猶其有四體也。有是四端而自謂不能者，自賊者也；謂其君不能者，賊其君者也。凡有四端於我者，知皆擴而充之矣，若火之始然，泉之始達。苟能充之，足以保四海；苟不充之，不足以事父母。」",
//                "孟子曰：「矢人豈不仁於函人哉？矢人唯恐不傷人，函人唯恐傷人。巫匠亦然，故術不可不慎也。孔子曰：『里仁為美。擇不處仁，焉得智？』夫仁，天之尊爵也，人之安宅也。莫之禦而不仁，是不智也。不仁、不智、無禮、無義，人役也。人役而恥為役，由弓人而恥為弓，矢人而恥為矢也。如恥之，莫如為仁。仁者如射，射者正己而後發。發而不中，不怨勝己者，反求諸己而已矣。」",
//                "孟子曰：「子路，人告之以有過則喜。禹聞善言則拜。大舜有大焉，善與人同。舍己從人，樂取於人以為善。自耕、稼、陶、漁以至為帝，無非取於人者。取諸人以為善，是與人為善者也。故君子莫大乎與人為善。」",
//                "孟子曰：「伯夷，非其君不事，非其友不友。不立於惡人之朝，不與惡人言。立於惡人之朝，與惡人言，如以朝衣朝冠坐於塗炭。推惡惡之心，思與鄉人立，其冠不正，望望然去之，若將浼焉。是故諸侯雖有善其辭命而至者，不受也。不受也者，是亦不屑就已。柳下惠，不羞汙君，不卑小官。進不隱賢，必以其道。遺佚而不怨，阨窮而不憫。故曰：『爾為爾，我為我，雖袒裼裸裎於我側，爾焉能浼我哉？』故由由然與之偕而不自失焉，援而止之而止。援而止之而止者，是亦不屑去已。」",
//                "孟子曰：「伯夷隘，柳下惠不恭。隘與不恭，君子不由也。"));
//
//
//        Random random1 = new Random();
//        StringBuffer sb1 = new StringBuffer();
//        for (int i = 0; i < 50; i++) {
//            int number = random1.nextInt(a.size());
//            sb1.append(a.get(number));
//        }
//
//        String ArticleDate="2020-08-20";
//
//       Answer answertmp=new Answer();
//        User user2tmm=userService.getUser(ss+1);
//        if(user2tmm==null){
//            continue;
//        }
//        String aa= userService.getUser(ss+1).getusername();
//       // question.setQuestionAuthor(aa);
//
//        //    String questionAuthor;
//
//
//        List<Tag> article_tags =new ArrayList<Tag>();
//        List<String> tagRan=new ArrayList<String>(Arrays.asList("html","css3","js","vue","react"));
//
//            Tag tagtmp=new Tag();
//            Random random2= new Random();
//            int ttmp=random2.nextInt(4);
//            tagtmp.setTagId(ttmp);
//            tagtmp.setTagName(tagRan.get(ttmp));
//            article_tags.add(tagtmp);
//
//      answertmp.setAnswerContent(sb1.toString());
//      answertmp.setuserid(ss);
//      answertmp.setAnswerDate(ArticleDate);
//      answertmp.setQuestionId(ss);
//      //System.out.println(question.toString());
//
//        answerService.addAnswer(answertmp);
//
////            System.out.println(sb.toString());
////            System.out.println(sb1.toString());
//
//
//
//    }
//    return true;
//}
//


    @PostMapping(value="/article/addArticle",consumes = "application/json")
    public boolean addArticle(@RequestBody Article article){
        boolean res= false;
        try {
            System.out.println("addArticle");
            System.out.println(article.toString2());
            System.out.println(userService.getUserByName(article.getArticleAuthor()));
            article.setArticleAuthorId(userService.getUserByName(article.getArticleAuthor()).getuserid());
            res=articleService.addArticle(article);

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error at /article/addArticle ");
            return false;
        }
        return res;
    }
//    @PostMapping(value="/article/addArticle",consumes = "application/json")
//    public boolean addArticle(@RequestBody Map<String,Object> article){
//
//        System.out.println(article);
//
//
//
//        return false;
//    }

//    @PostMapping(value="/article/addArticle")
//    public boolean addArticle(@RequestBody JSONObject article){
//        System.out.println(article.toString());
//    return true;
//    }


/*加文章标签数据*/
//    @GetMapping("/ss")
//    public boolean add(){
//
//        ArticleTag article_tag=new ArticleTag();
//        for(int i=1;i<205;i++){
//            Random random=new Random(i);
//
//            article_tag.setArticleId(i);
//            article_tag.setTagId(random.nextInt(4));
//
//            articleTagService.insertArticleTag(article_tag);
//            Random random2=new Random(i+1);
//
//            article_tag.setArticleId(i);
//            article_tag.setTagId((random.nextInt(4)+1)%5);
//
//            articleTagService.insertArticleTag(article_tag);
//
//        }
//    return true;
//    }


    /*加问题标签数据*/
//    @GetMapping("/aqt")
//    public boolean add(){
//
//        QuestionTag questionTag =new QuestionTag();
//        for(int i=1;i<200;i++){
//            Random random=new Random(i);
//
//            questionTag.setQuestionId(i);
//            questionTag.setTagId(random.nextInt(4));
//
//           questionTagService.insertArticleTag(questionTag);
//            Random random2=new Random(i+1);
//
//            questionTag.setQuestionId(i);
//            questionTag.setTagId((random.nextInt(4)+1)%5);
//
//            questionTagService.insertArticleTag(questionTag);
//
//        }
//    return true;
//    }

    @GetMapping("/article/getAllArticles")
    public List<Article> getAllArticle(){

        ArrayList<Article> articleList;

        User article_author=new User();
        List<User> like_users=new ArrayList<>(),collect_users=new ArrayList<>();
        List<Comment> comment_content=new ArrayList<>();
        try {
            articleList = new ArrayList<>(articleService.getAllArticle());

            if (articleList==null)
                return  null;
            else
            {

                for (Article a :articleList) {

                    List<Tag> article_tags=new ArrayList<>();
                    try{
                        int id1=a.getArticleAuthorId();

                        User tmpuser=userService.getUser(id1);

                        a.setArticleAuthor(tmpuser.getusername());
                    }
                  catch (Exception e){
                        System.out.println("catch:"+a.getArticleAuthorId());
                        e.printStackTrace();
                        continue;
                  }
                    List<ArticleTag> articleTagList=articleTagService.getArticleTag(a.getArticleId());

                    for(ArticleTag articleTagI:articleTagList){
                       // System.out.print( "arid"+a.getArticleId()+" tag"+articleTagI+"tmp1");
                        Tag tmp1=new Tag();
                        int tmp2=articleTagI.getTagId();
                               tmp1 =tagService.getTag(tmp2);
                       // System.out.println(tmp1+"tmp2"+tmp2);

                        article_tags.add(tmp1);
                    }
                   // System.out.println(article_tags);
                    a.setArticle_tag(article_tags);
                   // System.out.println("\n\n");



                    List<Like> likeList=likeService.getLike(a.getArticleId());
                    for(Like like:likeList){

                        like_users.add(userService.getUser(like.getuserid()));
                    }
                    User testUser=new User();

                    a.setLike_users(like_users);

                    List<Collect> collectList = collectService.getCollect(a.getArticleId());
                    for(Collect collect:collectList){
                        User tmpU=new User();
                        tmpU=userService.getUser(collect.getuserid());
                       // System.out.println(tmpU);
                        collect_users.add(tmpU);
                    }
                    a.setCollect_user(collect_users);

                    comment_content = commentService.getComment(a.getArticleId());

                    for(Comment comment:comment_content){

                        comment.setusername(userService.getUser(comment.getuserid()).getusername());
                    }

                    a.setComment_content(comment_content);

                }
              //  for(Article a: articleList)
               // System.out.println(a.toString());
            }
        }catch ( Exception e){
            e.printStackTrace();
            return null;
        }
        System.out.println("getAllArticle Success");
        return articleList;
    }


    @PostMapping("article/likeArticle")
    public boolean likeArticle(@RequestBody Map<String, Object> json){
        System.out.println(json);
        try{
            //User user= (User)json.get("user");
            User user = JSON.parseObject(JSON.toJSONString(json.get("user")),User.class);
            System.out.println(user.toString());
            int articleId = (int) json.get("article_id");
            boolean isLiked = (boolean) json.get("isliked");
            System.out.println(articleId);
            System.out.println(isLiked);

            if(isLiked){

                likeService.deleteLike(articleId,user.getuserid());
            }else{
                likeService.addLike(articleId,user.getuserid());
            }
        }catch ( Exception e){

            System.out.println("error at likeArticle");
            e.printStackTrace();

        }

        return true;
    }

    @PostMapping("article/collectArticle")
    public boolean collectArticle(@RequestBody Map<String, Object> json){
        System.out.println(json);
        try{
            //User user= (User)json.get("user");
            User user = JSON.parseObject(JSON.toJSONString(json.get("user")),User.class);
            System.out.println(user.toString());
            int articleId = (int) json.get("article_id");
            boolean isLiked = (boolean) json.get("iscollected");
            System.out.println(articleId);
            System.out.println(isLiked);

            if(isLiked){

                collectService.deleteCollect(articleId,user.getuserid());
            }else{
                collectService.addCollect(articleId,user.getuserid());
            }
        }catch ( Exception e){

            System.out.println("error at collectArticle");
            e.printStackTrace();

        }

        return true;
    }

//    @PostMapping("article/commentArticle")
//    public boolean commentArticle(@RequestBody Map<String, Object> json){
//        //post请求，五个参数（article_id,comment_id,comment_content,comment_date,
//        //user信息（一个对象）)
//        try{
//            User user;
//            int userid,articleId,commentId;
//            String commentContent,commentDate;
//
//            user=(User)json.get("user");
//            userid =user.getuserid();
//            commentId=(int) json.get("comment_id");
//            articleId = (int) json.get("article_id");
//            commentContent= (String) json.get("comment_content");
//            commentDate= (String) json.get("comment_date");
//
//
//        }catch ( Exception e){
//            e.printStackTrace();
//        }
//
//return true;
//    }

    @PostMapping("article/commentArticle")
    public boolean commentArticle(@RequestBody Comment comment){

        try{
            System.out.println(comment);
            comment.setuserid(comment.getUser().getuserid());
           boolean re= commentService.addComment(comment);

           return re;

        }catch ( Exception e){
            System.out.println("error at comment");
            e.printStackTrace();
            return false;
        }

    }
}
