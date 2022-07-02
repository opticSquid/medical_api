const lang_en = document.getElementById("lang_en");
//TODO: if I have already changed my Locale once that query param is remaining in url
// which is causing problems when I'm going to change my locale 2nd time need to remove the
// previous query param when in 2nd time we are changing locale
lang_en.href = window.location.href + "?myLocale=en";
const lang_de = document.getElementById("lang_de");
lang_de.href = window.location.href + "?myLocaled=de";