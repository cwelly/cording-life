using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class moveClear : MonoBehaviour {

    public GameObject des;
    public GameObject des_next;
    public GameObject sound;

    private void OnTriggerEnter(Collider col)
    {
        if (col.tag == "Player") {
            sound.SendMessage("enableSound");
            des_next.SetActive(true);
            des.SetActive(false);

        }
    }
}
