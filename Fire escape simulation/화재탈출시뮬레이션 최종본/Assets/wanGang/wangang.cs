using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class wangang : MonoBehaviour {
    public GameObject enablespace;
    public GameObject wanspace;
    [SerializeField] public Text wan_inform;
    [SerializeField] public Text loop_inform;
    [SerializeField] public Text loop_body_inform;
    [SerializeField] public Text wan_final;
    [SerializeField] public Image im;
    public GameObject sound;

    private bool enabling = false;
    private float waittime = 6;
	// Use this for initialization
	void Start () {
        wanspace.SetActive(false);
        im.enabled = false;
        loop_body_inform.enabled = false;
        loop_inform.enabled = false;
        wan_inform.enabled = false;
        wan_final.enabled = false;
	}
	
	// Update is called once per frame
	void Update () {
        if (enabling) {
            wan_inform.enabled = false;
            waittime -= Time.deltaTime;
            sound.SendMessage("enableSound");
            if (waittime < 0)
            {
                im.enabled = false;
                loop_inform.enabled = false;
                loop_body_inform.enabled = false;
                wanspace.SetActive(true);
                sound.SendMessage("disableSound");
                Destroy(enablespace);
            }
            else if (waittime < 3)
            {
                im.enabled = true;
                loop_inform.enabled = false;
                loop_body_inform.enabled = true;
            }
            else {
                im.enabled = true;
                loop_inform.enabled = true;
            }
        }
        else
            sound.SendMessage("disableSound");
    }

    private void OnTriggerStay(Collider col)
    {

        if (col.tag == "Player") {
            im.enabled = true;
            wan_inform.enabled = true;
            if (OVRInput.GetDown(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyDown(KeyCode.Space)) {
                wan_inform.enabled = false;
                enabling = true;
            }
            else if (OVRInput.GetUp(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKeyUp(KeyCode.Space))
            {
                im.enabled = true;
                loop_body_inform.enabled = false;
                loop_inform.enabled = false;
                wan_inform.enabled = true;
                enabling = false;
            }
        }
    }
    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player")
        {
            im.enabled = false;
            enabling = false;
            loop_body_inform.enabled = false;
            loop_inform.enabled = false;
            wan_inform.enabled = false;
        }
    }
}
