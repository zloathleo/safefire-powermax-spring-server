function _java_alert(_msg) {
    var node = document.createElement("div");
    var textnode = document.createTextNode("msg:" + _msg);
    node.appendChild(textnode);
    document.body.appendChild(node);
}

/////////////////////
////java
/////////////////////
function _app_instance_app_exit() {
    try {
        if (_app_instance) {
            _app_instance.appExit();
        } else {
            _java_alert('no _app_instance');
        }
    } catch (ex) {
        _java_alert('ex:' + ex);
    }

}