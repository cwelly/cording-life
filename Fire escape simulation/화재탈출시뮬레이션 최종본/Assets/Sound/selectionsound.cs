using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class selectionsound : MonoBehaviour {
    private float time = 0.3f;
    public GameObject sound;
    private bool enable = false;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        if (enable) {
            sound.SendMessage("enableSound");
            time -= Time.deltaTime;
            if (time < 0) {
                sound.SendMessage("disableSound");
                time = 0.3f;
                enable = false;
            }
           
        }
	}

    private void startSound() {
        enable = true;
    }
}
