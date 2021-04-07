using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class wan_bf : MonoBehaviour {
    [SerializeField] public Image im;
    [SerializeField] public Text wanuse_inform;
    public GameObject cam1;
    public GameObject cam2;
	// Use this for initialization
	void Start () {
        im.enabled = false;
        wanuse_inform.enabled = false;
        cam2.SetActive(false);
	}
	

    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player") {
            im.enabled = true;
            wanuse_inform.enabled = true;
            if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space)) {
                im.enabled = false;
                wanuse_inform.enabled = false;
                cam1.SetActive(false);
                cam2.SetActive(true);
            }
        }
    }
    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player")
        {
            im.enabled = false;
            wanuse_inform.enabled = false;
        }
    }
}
