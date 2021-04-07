using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class getglove : MonoBehaviour {

    [SerializeField] public Text inform;
    [SerializeField] public Image im;
    public GameObject sound;
    public GameObject enable_space;
    public GameObject frontdoorenable;
    public GameObject frontdoordisable;

    public Material blackglove;
    public Renderer lefthand;
	// Use this for initialization
	void Start () {
        im.enabled = false;
        inform.enabled = false;
        frontdoorenable.SetActive(false);
	}
	
	// Update is called once per frame
	void Update () {
		
	}

    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player") {
            inform.enabled = true;
            im.enabled = true;
            if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space)) {
                sound.SendMessage("enableSound");
                im.enabled = false;
                inform.enabled = false;
                Destroy(enable_space);
                lefthand.sharedMaterial = blackglove;
                frontdoordisable.SetActive(false);
                frontdoorenable.SetActive(true);
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
