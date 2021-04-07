using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class water : MonoBehaviour {

    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "fire") {
            col.SendMessage("DisableFire", Time.deltaTime);
        }
        
    }
}
