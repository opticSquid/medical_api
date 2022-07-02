const removeQparams = (url) => {
    if (url.includes("?")) {
        url = url.split("?");
        console.log("Split url: ",url)
        return url[0];
    } else {
        return url;
    }
};
let lang_en = document.getElementById("lang_en");
lang_en.onclick = () => {
    console.log("lang_en onClick");
    let url = removeQparams(window.location.href);
    location.assign(url+"?myLocale=en");
}
let lang_de = document.getElementById("lang_de");
lang_de.onclick = () => {
    console.log("lang_de onClick");
    let url = removeQparams(window.location.href);
    location.assign(url+"?myLocale=de");
}

