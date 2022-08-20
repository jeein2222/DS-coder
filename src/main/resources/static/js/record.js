function ajax_send(frm){
    const formData=$("#record-form").serializeObject();
    $.ajax({
        url:'record/create',
        type:'POST',
        contentType:'application/json',
        data:JSON.stringify(formData),
        success:function(data){
            console.log(data.data);
        },error:function(xhr,status,error){
            console.log("["+xhr.status+"]"+error);
        }
    });
    return false;
}

function removeAllchild(div){
    while(div.hasChildNodes()){
        div.removeChild(div.firstChild);
    }
}

function ajax_get(){
    const currentDiv=document.getElementById('records');
    removeAllchild(currentDiv);
    $.ajax({
            url : "record/retrieve", // test.jsp 에서 받아옴
            dataType :"json", // 데이터타입을 json 으로 받아옴
            success : function(data) {
                        let d=data.data;

                        for (let i=0;i<d.length;i++){
                            const button=document.createElement("button");
                            const id=document.createElement("p");
                            const title=document.createElement("p");
                            const time=document.createElement("p");
                            const food=document.createElement("p");

                            id.innerHTML=d[i]['id'];
                            title.innerHTML=d[i]['title']
                            time.innerHTML=d[i]['time']
                            food.innerHTML=d[i]['food'];
                            button.appendChild(id);
                            button.appendChild(title);
                            button.appendChild(time);
                            button.appendChild(food);
                            button.setAttribute('class',"btn btn-light");

                            currentDiv.appendChild(button);
                        }
            },
            error : function(e) {
                    console.log(e.responseText);
            }
    });
}

function ajax_delete(frm){
    const t=document.getElementById("title").value;
    const param={"title":t};
    $.ajax({
        url:'record/delete',
        type:'DELETE',
        data:param,
        success:function(data){
            console.log(data.data);
        },error:function(xhr,status,error){
            console.log("["+xhr.status+"]"+error);
        }
    });
    return false;
}