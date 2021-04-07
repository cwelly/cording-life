using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class soundenable : MonoBehaviour {
    public GameObject sound;
    public bool enablesound = false;
	// Use this for initialization
	void Start () {
        sound.SetActive(false);
	}
	
	// Update is called once per frame
	void Update () {
        if (enablesound)
        {
            sound.SetActive(true);
        }
        else
            sound.SetActive(false);
	}
    private void enableSound() {
        enablesound = true;
    }
    private void disableSound() {
        enablesound = false;
    }
}
