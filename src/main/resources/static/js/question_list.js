
window.onload = function ajax_get(){
    const currentDiv=document.getElementById('question_list');
    const accessToken=localStorage.getItem("token");
    $.ajax({
            url : 'http://localhost:8080/ds-sw/question/retrieve',
            dataType :"json",
            beforeSend:function (xhr){
                xhr.setRequestHeader("Content-type","application/json"),
                xhr.setRequestHeader("Authorization","Bearer "+accessToken);
            },
            success : function(data) {
                        let d=data.data;
                        console.log(d);
                        for (let i=0;i<d.length;i++){
                            const div0=document.createElement("div");
                            const a=document.createElement("a");
                            const img=document.createElement("img");
                            const div1=document.createElement("div");
                            const div2=document.createElement("div");
                            const title=document.createElement("h6");
                            const question=document.createElement("p");
                            const code=document.createElement("p");
                            const id=document.createElement("small");

                            div0.setAttribute("class","list-group w-auto")
                            a.setAttribute("href",getQuestionInfo);
                            a.setAttribute("class","list-group-item list-group-item-action d-flex gap-3 py-3");
                            a.setAttribute("aria-current","true")
                            img.setAttribute("src","/img/question_Img.JPG");
                            div1.setAttribute("class","d-flex gap-2 w-100 justify-content-between");
                            title.setAttribute("class","mb-0");
                            title.setAttribute("id","atitle");
                            question.setAttribute("class","mb-0 opacity-75")
                            question.setAttribute("id","aquestion");
                            code.setAttribute("id","acode");
                            id.setAttribute("class","opacity-50 text-nowrap")
                            id.setAttribute("id","aid");


                            title.innerHTML=d[i]['title']
                            question.innerHTML=d[i]['question']
                            code.innerHTML=d[i]['code'];
                            id.innerHTML=d[i]['id'];


                            div2.appendChild(title);
                            div2.appendChild(question);
                            div2.appendChild(code);
                            div1.appendChild(div2);
                            div1.appendChild(id)
                            a.appendChild(img)
                            a.appendChild(div1)
                            div0.appendChild(a)

                            currentDiv.appendChild(div0);
                        }
            },
            error : function(e) {
                    console.log(e.responseText);
            }
    });
}

function getQuestionInfo(e){
    if (e.target !== e.currentTarget)
            return;
        e.preventDefault();
    const a = e.target;
    let listChild=a.childNodes;
    let id=document.getElementById("id");
    let title=document.getElementById("title");
    let question=document.getElementById("question");
    let code=document.getElementById("code");

    id.value=listChild[0].innerHTML;
    title.value=listChild[1].innerHTML;
    question.value=listChild[2].innerHTML;
    code.value=listChild[3].innerHTML;

}