const toastTrigger = document.getElementById('triggerToast')
const toastLiveExample = document.getElementById('liveToast')
if (toastTrigger) {
    toastTrigger.addEventListener('click', () => {
        const toast = new bootstrap.Toast(toastLiveExample)
        console.log("toast triggered");
        toast.show()
    })
}