using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class disablefire : MonoBehaviour {
    [SerializeField] public Text fire_inform;
    [SerializeField] public Image fire_panel;
    [SerializeField] public Text elec_imform;
    [SerializeField] public Image elec_panel;
    public GameObject sound;
    public GameObject sound1;
    public GameObject offsound;
    public float waittime = 2f;
    private bool enablefire = true;
    public GameObject Fire;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        if (!enablefire) {

            offsound.SendMessage("enableSound");
            fire_inform.enabled = false;
            fire_panel.enabled = false;
            elec_imform.enabled = false;
            elec_panel.enabled = false;
            Fire.SetActive(false);

        }
	}
    private void DisableFire(float time) {
        waittime -= time;
        if (waittime < 0) {
            enablefire = false;
            sound.SendMessage("disableSound");
            sound1.SendMessage("disableSound");
        }
    }
}
