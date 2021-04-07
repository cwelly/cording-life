using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class get_onefireExtin : MonoBehaviour {
    public GameObject fireExtinguisher;
    public GameObject enable_space;
    [SerializeField] public Text inform;
    [SerializeField] public Image im;
    // Use this for initialization
    void Start () {
        im.enabled = false;
        inform.enabled = false;
	}

    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player")
        {
            im.enabled = true;
            inform.enabled = true;
            if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space))
            {
                im.enabled = false;
                inform.enabled = false;
                fireExtinguisher.SetActive(true);
                Destroy(enable_space);
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
