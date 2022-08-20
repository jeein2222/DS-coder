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

function getHealth(e){
    if (e.target !== e.currentTarget)
        return;
    e.preventDefault();
    console.log(e.target);
    let listChild=e.target.childNodes;
    let id=document.getElementById("id");
    id.style.display = "block";
    document.getElementById("id_label").style.display = "block";
    id.value=listChild[0].innerHTML;
}

function ajax_get(){
    const currentDiv=document.getElementById('records');
    removeAllchild(currentDiv);
    $.ajax({
            url : "record/retrieve",
            dataType :"json",
            success : function(data) {
                        let d=data.data;

                        for (let i=0;i<d.length;i++){
                            const button=document.createElement("button");
                            const id=document.createElement("p");
                            const title=document.createElement("p");
                            const time=document.createElement("p");
                            const food=document.createElement("p");
                            id.setAttribute("id","bid");
                            title.setAttribute("id","btitle");
                            time.setAttribute("id","btime");
                            id.innerHTML=d[i]['id'];
                            title.innerHTML=d[i]['title']
                            time.innerHTML=d[i]['time']
                            food.innerHTML=d[i]['food'];

                            button.appendChild(id);
                            button.appendChild(title);
                            button.appendChild(time);
                            button.appendChild(food);

                            button.setAttribute('class',"btn btn-light");
                            button.addEventListener('click',getHealth);
                            currentDiv.appendChild(button);
                        }
            },
            error : function(e) {
                    console.log(e.responseText);
            }
    });
}

function ajax_delete(frm){
    const formData=$("#record-form").serializeObject();
    const param={"id":id};
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
    document.getElementById("id").style.display = "none";
    document.getElementById("id_label").style.display = "none";
    return false;
}

function ajax_update(frm){
    const formData=$("#record-form").serializeObject();
    $.ajax({
            url:'record/update',
            type:'PUT',
            contentType:'application/json',
            data:JSON.stringify(formData),
            success:function(data){
                console.log(data.data);
            },error:function(xhr,status,error){
                console.log("["+xhr.status+"]"+error);
            }
        });
        return false;
    document.getElementById("id").style.display = "none";
    document.getElementById("id_label").style.display = "none";

    return false;

}