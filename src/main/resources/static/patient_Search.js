document.getElementById("id").addEventListener("click",()=>{
    console.log("id_filter");
    document.getElementById("search_cat").innerHTML = document.getElementById("id").innerHTML;
    let form = document.getElementById("search_from");
    let form_action = form.getAttribute("action");
    form.action=form_action+"/id";
});
document.getElementById("patient_name").addEventListener("click",()=>{
   console.log("name_filter");
   document.getElementById("search_cat").innerHTML = document.getElementById("patient_name").innerHTML;
    let form = document.getElementById("search_from");
    let form_action = form.getAttribute("action");
    form.action=form_action+"/name";
});
document.getElementById("patient_email").addEventListener("click",()=>{
    console.log("spec_filter");
    document.getElementById("search_cat").innerHTML = document.getElementById("patient_email").innerHTML;
    let form = document.getElementById("search_from");
    let form_action = form.getAttribute("action");
    form.action=form_action+"/email";
});

