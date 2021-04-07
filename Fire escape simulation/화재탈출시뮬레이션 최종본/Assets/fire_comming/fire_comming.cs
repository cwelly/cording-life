using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class fire_comming : MonoBehaviour {
    [SerializeField] public Image im_nar;
    [SerializeField] public Text comeText;
    public GameObject enablespace;
    public GameObject sound;

    private bool enableText = false;
    private float waittime = 3;

	// Use this for initialization
	void Start () {
        im_nar.enabled = false;
        comeText.enabled = false;
	}
	
	// Update is called once per frame
	void Update () {
        if (enableText) {
            im_nar.enabled = true;
            comeText.enabled = true;

            waittime -= Time.deltaTime;
            if (waittime < 0) {
                sound.SendMessage("disableSound");
                im_nar.enabled = false;
                comeText.enabled = false;
                Destroy(enablespace);
            }
        }
	}

    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player") {
            sound.SendMessage("enableSound");
            im_nar.enabled = true;
            enableText = true;
        }
    }
}
