using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class ExplainScript : MonoBehaviour {

    [SerializeField]public Text back;
    private bool BackEnable;
    private float waittime = 2;

	// Use this for initialization
	void Start () {
        BackEnable = false;
        back.enabled = false;
	}
	
	// Update is called once per frame
	void Update () {
        if (waittime > 0)
        {
            waittime -= Time.deltaTime;
        }
        else if (waittime <= 0) {
            waittime = 0;
            BackEnable = true;
            back.enabled = true;
        }
        if (BackEnable) {
            if (OVRInput.GetUp(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyUp(KeyCode.Space)){
                SceneManager.LoadScene("START");
            }
        }
	}
}
