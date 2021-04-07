using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class fire_bang : MonoBehaviour {
    public GameObject particle;
    public GameObject none;
    public GameObject sound;
	// Update is called once per frame
	void Update () {
        if (OVRInput.GetDown(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyDown(KeyCode.Space))
        {
            none.SetActive(false);
            particle.SetActive(true);
            sound.SendMessage("enableSound");
        }
        else if (OVRInput.GetUp(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyUp(KeyCode.Space)) {
            particle.SetActive(false);
            none.SetActive(true);
            sound.SendMessage("disableSound");
        }
    }
}
