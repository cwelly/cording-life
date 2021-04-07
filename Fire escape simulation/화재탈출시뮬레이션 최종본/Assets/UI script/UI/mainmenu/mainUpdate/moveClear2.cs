using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class moveClear2 : MonoBehaviour
{
    public GameObject manager;
    public GameObject des;
    public GameObject sound;

    private void OnTriggerEnter(Collider col)
    {
        if (col.tag == "Player")
        {   manager.SendMessage("EnableExtin");
            sound.SendMessage("enableSound");
            des.SetActive(false);

        }
    }
}
