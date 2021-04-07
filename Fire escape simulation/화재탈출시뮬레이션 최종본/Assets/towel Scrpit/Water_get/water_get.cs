using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class water_get : MonoBehaviour {
    [SerializeField] public Image im;
    [SerializeField] public Image im_nar;
    [SerializeField] public Text inform;
    [SerializeField] public Text water_text;
    private bool textenable = false;
    public GameObject sound;
    public GameObject MainGameManager;
    public GameObject righthand;
    public GameObject enable_space;
    private float waittime = 3;
    // Use this for initialization
    void Start () {
        im.enabled = false;
        im_nar.enabled = false;
        inform.enabled = false;
        water_text.enabled = false;
	}
	
	// Update is called once per frame
	void Update () {
        if (textenable)
        {
            waittime -= Time.deltaTime;
            im_nar.enabled = true;
            water_text.enabled = true;
            if (waittime < 0)
            {
                im.enabled = false;
                im_nar.enabled = false;
                inform.enabled = false;
                water_text.enabled = false;
                MainGameManager.SendMessage("DisableDamaging");
                Destroy(enable_space);
            }
        }
    }
    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player" && !textenable)
        {
            im.enabled = true;
            inform.enabled = true;
            if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space))
            {
                sound.SendMessage("enableSound");
                im.enabled = false;
                inform.enabled = false;
                textenable = true;
                Destroy(righthand);
            }
        }
    }
    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player")
        {
            im.enabled = false;
            inform.enabled = false;
        }
    }
}
