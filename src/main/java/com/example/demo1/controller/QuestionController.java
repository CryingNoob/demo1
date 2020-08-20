package com.example.demo1.controller;

import com.example.demo1.bean.*;
import com.example.demo1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class QuestionController {
    private AnswerService answerService;
    @Resource
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    private TagService tagService;
    @Resource
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    private QuestionTagService questionTagService;
    @Resource
    public void setQuestionTagService(QuestionTagService questionTagService) {
        this.questionTagService = questionTagService;
    }

    private UserService userService;
    @Resource
    public  void setUserService(UserService userService){
        this.userService = userService;
    }

    private QuestionService questionService;
    @Resource
    public void setQuestionService(QuestionService questionService){
        this.questionService = questionService;

    }
//int questionId;
//    String questionAuthor;
//    String questionContent;
//    String questionDate;
//    int answerNumber;
//    List<Tag> questionTag;
//    List<Answer> answerContent;

    @GetMapping("question/getAllQuestions")
    List<Question> getAllQuestions(){
        List<Question> res=null;

        List<Answer> answerContent=new ArrayList<Answer>();
        try{

            res = questionService.getAllQuestion();

            for(Question question : res){
                List<Tag> tag=new ArrayList<Tag>();
                List<QuestionTag> questionTagList = questionTagService.getQuestionTag(question.getQuestionId());
                for(QuestionTag tag1 : questionTagList){

                    tag.add(tagService.getTag(tag1.getTagId()));

                }

                question.setQuestionTag(tag);

                answerContent = answerService.getAnswer(question.getQuestionId());
                for(Answer answer : answerContent){
                   // System.out.println(answer.toString());
                    User tempUser = new User();
                    tempUser= userService.getUser(answer.getuserid());
                   // System.out.println(answer.getuserid());
                   // System.out.println(tempUser.toString());
                    String tmpname = tempUser.getusername();
                    answer.setusername(tmpname);
                }

                question.setAnswerContent(answerContent);
            }

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

       // System.out.println(res.toString());
        return res;
    }

    @PostMapping("question/writeAnswer")
    public boolean writeAnswer(@RequestBody Answer answer){

        boolean res=false;
        try{
            res=answerService.addAnswer(answer);
        }catch ( Exception e){
            System.out.println("error at WriteAnswer");
            e.printStackTrace();

        }
        return res;

    }
//六个参数（问题id,question_author,question_content,
//question_date(YYYY-MM-DD格式),question_tag(对象数组))


    //int questionId;
    //    String questionAuthor;
    //    String questionContent;
    //    String questionDate;
    //    int answerNumber;
    //    List<Tag> questionTag;
    //    List<Answer> answerContent;
    @PostMapping("question/addQuestion")
    public boolean addQuestion(@RequestBody Question question){

        boolean res = false;
        try{
            res=questionService.addQuestion(question);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

     //添加问题
   /* @GetMapping("/aq")
    public boolean addQuestion(){
        List<String> a= new ArrayList<String>(Arrays.asList("大學之道，在明明德，在親民，在止於至善。知止而后有定，定而后能靜，靜而后能安，安而后能慮，慮而后能得。則近道矣。",
                 "《詩》云：「潛雖伏矣，亦孔之昭！」故君子內省不疚，無惡於志。君子所不可及者，其唯人之所不見乎！",
                "《詩》云：「相在爾室，尚不愧于屋漏。」故君子不動而敬，不言而信。",
                "《詩》曰：「奏假無言，時靡有爭。」是故君子不賞而民勸，不怒而民威於鈇鉞。",
                "《詩》曰：「不顯惟德！百辟其刑之。」是故君子篤恭而天下平。",
                "《詩》曰：「予懷明德，不大聲以色。」子曰：「聲色之於以化民，末也。」《詩》曰：「德輶如毛」，毛猶有倫；「上天之載，無聲無臭」，至矣！"
                ,"莊暴見孟子，曰：「暴見於王，王語暴以好樂，暴未有以對也。」曰：「好樂何如？」",
                "孟子曰：「王之好樂甚，則齊國其庶幾乎！」",
              "齊宣王問曰：「文王之囿方七十里，有諸？」",

                "曰：「士師不能治士，則如之何？」",
                "王曰：「已之。」",
                "曰：「四境之內不治，則如之何？」",
                "王顧左右而言他。",

              "曰：「管仲以其君霸，晏子以其君顯。管仲、晏子猶不足為與？」",
                "曰：「以齊王，由反手也。」",
                "曰：「若是，則弟子之惑滋甚。且以文王之德，百年而後崩，猶未洽於天下；武王、周公繼之，然後大行。今言王若易然，則文王不足法與？」",
                "曰：「文王何可當也？由湯至於武丁，賢聖之君六七作。天下歸殷久矣，久則難變『雖有智慧，不如乘勢；雖有鎡基，不如待時。』",
                "「今時則易然也。夏后、殷、周之盛，地未有過千里者也，而齊有其地功必倍之，惟此時為然。」",
                "公孫丑問曰：「夫子加齊之卿相，得行道焉，雖由此霸王不異矣。如此，則動心否乎？」",
                "孟子曰：「否。我四十不動心。」",
                "曰：「若是，則夫子過孟賁遠矣。」",
                "曰：「是不難，告子先我不動心。」",
                "曰：「不動心有道乎？」",
                "曰：「有。北宮黝之養勇也，不膚撓，不目逃，思以一豪挫於人，若撻之於市朝。不受於褐寬博，亦不受於萬乘之君。。」",
                "曰：「敢問夫子之不動心，與告子之不動心，可得聞與？」",
                "「告子曰：『不得於言，勿求於心；不得於心，勿求於氣。』不得焉，氣次焉。故曰：『持其志，無暴其氣。』」",
                "「既曰『志至焉，氣次焉』，又曰『持其志無暴其氣』者，何也？」",
                "曰：「志壹則動氣，氣壹則動志也。今夫蹶者趨者，是氣也，而反動其心。」",
                "「敢問夫子惡乎長？」",
                "曰：「我知言，我善養吾浩然之氣。」",
                "「敢問何謂浩然之氣？」",
                 "「何謂知言？」",
                "曰：「詖辭知其所蔽，淫辭知其所陷，邪辭知其所離，遁辭知其所窮。生於其心，害於其政；發於其政，害於其事。聖人復起，必從吾言矣。」",
                "「宰我、子貢善為說辭，冉牛、閔子、顏淵善言德行。孔子兼之，曰：『我於辭命則不能也。』然則夫子既聖矣乎？」",
                "曰：「惡！是何言也？昔者子貢、問於孔子曰：『夫子聖矣乎？』孔子曰：『聖則吾不能，我學不厭而教不倦也。』？」",
                "「昔者竊聞之：子夏、子游、子張皆有聖人之一體，冉牛、閔子、顏淵則具體而微。敢問所安。」",
                "曰：「姑舍是。」",
                "曰：「伯夷、伊尹何如？」",
                "曰：「不同道。非其君不事，非其民不使；治則進，亂則退，伯夷也。何事非君，何使非民；治亦進，亂亦進，伊尹也。。」",
                "「伯夷、伊尹於孔子，若是班乎？」",
                "曰：「否。自有生民以來，未有孔子也。」",
                "曰：「然則有同與？」",
                "曰：「有。得百里之地而君之，皆能以朝諸侯有天下。行一不義、殺一不辜而得天下，皆不為也。是則同。」",
                "曰：「敢問其所以異？」",
                "孟子曰：「伯夷隘，柳下惠不恭。隘與不恭，君子不由也。"));

//  int answerId,userid,questionId;
//    String answerContent,answerDate;
        int questionId;
            String questionAuthor;
            String questionContent;
           String questionDate;
           int answerNum;
           Question question=new Question();
          for(int i=1;i<200;i++) {
              Random random=new Random();
              questionId=i;
              questionContent=a.get(random.nextInt(a.size()));
              questionDate="2020-08-20";
              answerNum=random.nextInt(10);

              question.setQuestionId(questionId);
              question.setQuestionContent(questionContent);
              question.setQuestionAuthor(userService.getUser(i).getusername());
              question.setQuestionDate(questionDate);
              question.setAnswerNumber(answerNum);

              questionService.addQuestion(question);
          }

        boolean res = false;
        try{
            res=questionService.addQuestion(question);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
*/


    //  int answerId,userid,questionId;
//    String answerContent,answerDate;
    @GetMapping("/aa")
    public boolean addAnswer(){

        Answer answer=new Answer();
       List<Question>  questionList=new ArrayList<Question>();
        questionList=questionService.getAllQuestion();
        for(Question question:questionList){

            for(int i=0;i<question.getAnswerNumber();i++){

                List<String> a= new ArrayList<String>(Arrays.asList("大學之道，在明明德，在親民，在止於至善。知止而后有定，定而后能靜，靜而后能安，安而后能慮，慮而后能得。則近道矣。",
                        "《詩》云：「潛雖伏矣，亦孔之昭！」故君子內省不疚，無惡於志。君子所不可及者，其唯人之所不見乎！",
                        "《詩》云：「相在爾室，尚不愧于屋漏。」故君子不動而敬，不言而信。",
                        "《詩》曰：「奏假無言，時靡有爭。」是故君子不賞而民勸，不怒而民威於鈇鉞。",
                        "《詩》曰：「不顯惟德！百辟其刑之。」是故君子篤恭而天下平。",
                        "《詩》曰：「予懷明德，不大聲以色。」子曰：「聲色之於以化民，末也。」《詩》曰：「德輶如毛」，毛猶有倫；「上天之載，無聲無臭」，至矣！"
                        ,"莊暴見孟子，曰：「暴見於王，王語暴以好樂，暴未有以對也。」曰：「好樂何如？」",
                        "孟子曰：「王之好樂甚，則齊國其庶幾乎！」",
                        "齊宣王問曰：「文王之囿方七十里，有諸？」",

                        "曰：「士師不能治士，則如之何？」",
                        "王曰：「已之。」",
                        "曰：「四境之內不治，則如之何？」",
                        "王顧左右而言他。",

                        "曰：「管仲以其君霸，晏子以其君顯。管仲、晏子猶不足為與？」",
                        "曰：「以齊王，由反手也。」",
                        "曰：「若是，則弟子之惑滋甚。且以文王之德，百年而後崩，猶未洽於天下；武王、周公繼之，然後大行。今言王若易然，則文王不足法與？」",
                        "曰：「文王何可當也？由湯至於武丁，賢聖之君六七作。天下歸殷久矣，久則難變『雖有智慧，不如乘勢；雖有鎡基，不如待時。』",
                        "「今時則易然也。夏后、殷、周之盛，地未有過千里者也，而齊有其地功必倍之，惟此時為然。」",
                        "公孫丑問曰：「夫子加齊之卿相，得行道焉，雖由此霸王不異矣。如此，則動心否乎？」",
                        "孟子曰：「否。我四十不動心。」",
                        "曰：「若是，則夫子過孟賁遠矣。」",
                        "曰：「是不難，告子先我不動心。」",
                        "曰：「不動心有道乎？」",
                        "曰：「有。北宮黝之養勇也，不膚撓，不目逃，思以一豪挫於人，若撻之於市朝。不受於褐寬博，亦不受於萬乘之君。。」",
                        "曰：「敢問夫子之不動心，與告子之不動心，可得聞與？」",
                        "「告子曰：『不得於言，勿求於心；不得於心，勿求於氣。』不得焉，氣次焉。故曰：『持其志，無暴其氣。』」",
                        "「既曰『志至焉，氣次焉』，又曰『持其志無暴其氣』者，何也？」",
                        "曰：「志壹則動氣，氣壹則動志也。今夫蹶者趨者，是氣也，而反動其心。」",
                        "「敢問夫子惡乎長？」",
                        "曰：「我知言，我善養吾浩然之氣。」",
                        "「敢問何謂浩然之氣？」",
                        "「何謂知言？」",
                        "曰：「詖辭知其所蔽，淫辭知其所陷，發於其政，害於其事。聖人復起，必從吾言矣。」",
                        "「宰我、子貢善為說辭，冉牛、閔子、顏淵善言德行。孔子兼之，曰：『我於辭命則不能也。』然則夫子既聖矣乎？」",
                        "曰：「惡！是何言也？昔者子貢、問於孔子曰：『夫子聖矣乎？』孔子曰：『聖則吾不能，我學不厭而教不倦也。』？」",
                        "「昔者竊聞之：子夏、子游、子張皆有聖人之一體，冉牛、閔子、顏淵則具體而微。敢問所安。」",
                        "曰：「姑舍是。」",
                        "曰：「伯夷、伊尹何如？」",
                        "曰：「不同道。非其君不事，非其民不使；治則進，亂則退，伯夷也。何事非君，何使非民；治亦進，亂亦進，伊尹也。。」",
                        "「伯夷、伊尹於孔子，若是班乎？」",
                        "曰：「否。自有生民以來，未有孔子也。」",
                        "曰：「然則有同與？」",
                        "曰：「有。得百里之地而君之，皆能以朝諸侯有天下。行一不義、殺一不辜而得天下，皆不為也。是則同。」",
                        "曰：「敢問其所以異？」",
                        "孟子曰：「伯夷隘，柳下惠不恭。隘與不恭，君子不由也。"));
                int userid,questionId;
                String answerContent,answerDate;

                Random random=new Random();
                userid=random.nextInt(200);
                questionId=question.getQuestionId();
                answerDate="2020-09-21";
                answerContent=a.get(random.nextInt(a.size())) ;

                answer.setAnswerDate(answerDate);
                answer.setuserid(userid);
                answer.setQuestionId(questionId);
                answer.setAnswerContent(answerContent);

                answerService.addAnswer(answer);

            }

        }


        return true;
    }
}
