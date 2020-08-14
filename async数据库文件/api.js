let apiBaseurl="http://localhost:8080/"

//article模块
/*
获取所有文章请求
get请求，返回所有文章信息的数组
*/
let getAllArticles = apiBaseurl+"article/getAllArticles"
/*
分页请求
get请求，两个参数（当前页，每页的文章数量），返回对应数量的article数组
*/
let getArticlesByPage = apiBaseurl+"article/getArticlesByPage"
/*
添加文章请求
post请求，六个参数（文章id，article_title,article_author,article_content,
article_date(YYYY-MM-DD格式),article_tag(对象数组))
返回添加是否成功的信息
*/
let addArticle = apiBaseurl+"article/addArticle"
/*
文章点赞的请求
post请求，三个参数（user信息，article_id，isliked（是否已经点赞，如果点赞了
就取消，没点赞就点赞）
返回点赞是否成功的消息
*/
let likeArticle = apiBaseurl+"article/likeArticle"
/*
评论文章的请求
post请求，五个参数（article_id,comment_id,comment_content,comment_date,
user信息（一个对象）)
返回是否评论成功
*/
let commentArticle = apiBaseurl+"article/commentArticle"
/*
文章收藏的请求
post请求，三个参数（user信息，article_id，iscollected（是否已经收藏，如果点赞了
就收藏，没收藏就收藏）
返回收藏是否成功的消息
*/
let collectArticle = apiBaseurl+"article/collectArticle"


//question模块
/*
获取所有问题请求
get请求，返回所有问题信息的数组
*/
let getAllQuestions = apiBaseurl+"question/getAllQuestions"

//user模块
/*
登录
get请求，两个参数（username，password），返回整个user的信息
*/
let signin = apiBaseurl+'user/signin'

//注册