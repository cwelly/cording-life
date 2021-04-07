using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class frontdoorDisable : MonoBehaviour {
    [SerializeField] public Text inform;
    [SerializeField] public Text disabledoorinform;
    [SerializeField] public Image im;
    [SerializeField] public Image im_nar;
    public GameObject sound;
    private bool textenable = false;
    private float waittime = 2;
	// Use this for initialization
	void Start () {
        im.enabled = false;
        im_nar.enabled = false;
        inform.enabled = false;
        disabledoorinform.enabled = false;

    }
	
	// Update is called once per frame
	void Update () {
        if (textenable) {
            waittime -= Time.deltaTime;
            disabledoorinform.enabled = true;
            im_nar.enabled = true;
            if (waittime < 0) {
                sound.SendMessage("disableSound");
                waittime = 2;
                im_nar.enabled = false;
                disabledoorinform.enabled = false;
                textenable = false;
            }
        }
	}
    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player")
        {
            im.enabled = true;
            inform.enabled = true;
            if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space))
            {
                sound.SendMessage("enableSound");
                textenable = true;
            }
        }
    }
    private void OnTriggerExit(Collider col)
    {
        im.enabled = false;
        inform.enabled = false;
    }

}
