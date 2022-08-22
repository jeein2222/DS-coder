
window.onload = function ajax_get(){
    const currentDiv=document.getElementById('question_list');
    $.ajax({
            url : 'http://localhost:8080/ds-sw/question/retrieve',
            dataType :"json",
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
                            const id=document.createElement("small");

                            div0.setAttribute("class","list-group w-auto")
                            a.setAttribute("href","/question/"+d[i]['id']);
                            a.setAttribute("class","list-group-item list-group-item-action d-flex gap-3 py-3");
                            a.setAttribute("aria-current","true")
                            img.setAttribute("src","/img/question_Img.JPG");
                            div1.setAttribute("class","d-flex gap-2 w-100 justify-content-between");
                            title.setAttribute("class","mb-0");
                            question.setAttribute("class","mb-0 opacity-75")
                            id.setAttribute("class","opacity-50 text-nowrap")

                            title.innerHTML=d[i]['title']
                            question.innerHTML=d[i]['question']
                            id.innerHTML=d[i]['id'];

                            div2.appendChild(title);
                            div2.appendChild(question)
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

