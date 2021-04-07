using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class eleczone : MonoBehaviour {

    public GameObject sound;

    private void OnTriggerStay(Collider col)
    {
        if(col.tag == "Player")
           sound.SendMessage("enableSound");
    }
    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player")
            sound.SendMessage("disableSound");
    }
}
