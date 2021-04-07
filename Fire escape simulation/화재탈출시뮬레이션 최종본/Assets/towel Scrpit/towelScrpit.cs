using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class towelScrpit : MonoBehaviour {
    [SerializeField] public Text inform;
    [SerializeField] public Text towel_text;
    [SerializeField] public Image im;
    [SerializeField] public Image im_nar;
    public GameObject sound;
    private float waittime = 3;
    private bool text_enable = false;
    public GameObject enable_space;
    public GameObject towel;
    public GameObject water_enablespace;
	// Use this for initialization
	void Start () {
        im.enabled = false;
        im_nar.enabled = false;
        inform.enabled = false;
        towel_text.enabled = false;
        water_enablespace.SetActive(false);
	}
	
	// Update is called once per frame
	void Update () {
        if (text_enable) {
            waittime -= Time.deltaTime;
            towel_text.enabled = true;
            im_nar.enabled = true;
            if (waittime < 0) {
                im.enabled = false;
                im_nar.enabled = false;
                inform.enabled = false;
                towel_text.enabled = false;
                Destroy(enable_space);
                water_enablespace.SetActive(true);
            }
        }
	}

    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player"&& !text_enable) {
            im.enabled = true;
            inform.enabled = true;
            if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space))
            {
                sound.SendMessage("enableSound");
                im.enabled = false;
                inform.enabled = false;
                text_enable = true;
                Destroy(towel);
            }
        }
    }
    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player") {
            im.enabled = false;
            inform.enabled = false;
        }
    }
}
